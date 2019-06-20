package cn.zkw.controller.back;

import cn.zkw.service.ArticleService;
import cn.zkw.service.UserService;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.vo.Article;
import cn.zkw.vo.User;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/back/article")
public class ArticleController extends AbstractAction {
    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

//String article_content,String article_title,String article_keyword,String article_describe
//            ,String sort_id,String label_name
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addArticle(Article article){
        User user =  userService.getUserByName(String.valueOf(SecurityUtils.getSubject().getPrincipal()));  //查询当前用户的id
        article.setUser_id(user.getUser_id());
        article.setArticle_date(new Date());
        articleService.addArticle(article);
        System.out.println(article);
        return null;
    }


    //文章图片上传,,给uedirot使用的
    @RequestMapping(value = "/uploadimage",method = RequestMethod.POST)
    public Object uploadImg(MultipartFile upfile, HttpServletRequest request){
        System.out.println("into uploadAction");
        JSONObject jsonObject = new JSONObject();
        String filename = upfile.getName();  //ueditor UUID生成图片名,,来自ueditor富文本编辑器
        String url = "/uploadFiles/atricleImg/"+filename;
        jsonObject.put("url",url);    //设置图片路径
        jsonObject.put("title",filename);  //图片名称
        jsonObject.put("original",filename);  //图片名称
        if(super.saveFile(upfile,filename,request)){  //保存图片
            System.out.println("保存成功");
            jsonObject.put("state","SUCCESS");
        }else{
            System.out.println("保存失败");
            jsonObject.put("state","ERROR");
        }
        return jsonObject;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getFileUploadDir() {
        return "/uploadFiles/atricleImg";
    }
}
