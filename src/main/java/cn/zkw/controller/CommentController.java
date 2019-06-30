package cn.zkw.controller;

import cn.zkw.service.ArticleService;
import cn.zkw.service.CommentService;
import cn.zkw.service.UserService;
import cn.zkw.util.AddressUtils;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.util.encrypt.MyPasswordEncrypt;
import cn.zkw.vo.Article;
import cn.zkw.vo.Comment;
import cn.zkw.vo.User;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Controller
public class CommentController extends AbstractAction {
    Logger logger = Logger.getLogger("CommentController");

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;
    /**
     * 文章评论添加
     * @param comment
     * @return
     */
    @RequestMapping("/comment/add")
    public String commentAdd(Comment comment,HttpServletRequest request){
        Article article = (Article)request.getSession().getAttribute("article");  //获取当前文章属性,来自文章跳转controller
        comment.setArticle_id(article.getArticle_id()); //设置文章id
        String user_name = (String) SecurityUtils.getSubject().getPrincipal();  //查询当前用户
        if(SecurityUtils.getSubject().isAuthenticated()==true){
            User user =  userService.getUserByName(user_name);
            comment.setUser_id(user.getUser_id());   //设置用户id
            comment.setUser_name(user.getUser_nickname());  //设置用户昵称
        }else{
            String ip = this.getIpAddress(request);  //获取ip
            logger.info("*************************************:"+ip); //输出日志,ip
            System.out.println("*****************"+ip);
            AddressUtils addressUtils = new AddressUtils(); //用户地址解析类
            String user_name_addr = null;
            try {//这里在阿里云返回null
                user_name_addr = addressUtils.getAddresses("ip="+ip,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            comment.setUser_name(user_name_addr);
        }
        comment.setComment_date(new Date());  //设置日期
        comment.setParent_comment_id(0);
        commentService.addComment(comment);
        String redirectUrl = "redirect:/front/article?article_id="+article.getArticle_id();
        return redirectUrl;  //ControllerUtil 前台文章页面跳转controller
    }


    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }


    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getFileUploadDir() {
        return "/uploadFiles/userPhoto";
    }
}
