package cn.zkw.controller.back;

import cn.zkw.service.ArticleService;
import cn.zkw.service.CommentService;
import cn.zkw.service.SortService;
import cn.zkw.service.UserService;
import cn.zkw.util.action.AbstractAction;
import cn.zkw.vo.Article;
import cn.zkw.vo.Comment;
import cn.zkw.vo.User;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/back/article")
public class ArticleController extends AbstractAction {
    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    SortService sortService;

    //滚动加载
    @RequestMapping(value = "/page")
    public String splitArticle(Integer nextPage, Model model,HttpServletRequest request){
        if(nextPage ==null){
            nextPage = 0;
        }
        List<Article> articles = articleService.splitArticle(nextPage);
        model.addAttribute("articles",articles);  //获取文章
        //总数
        int count = articleService.getArticleAllNum();
        //总页数
        int pageNum = count / 5;
        model.addAttribute("pageNum",pageNum);
        if (pageNum > nextPage) {
            model.addAttribute("nextPage", nextPage + 5);
        }else{
            model.addAttribute("nextPage", nextPage + 5);
//            model.addAttribute("articles",null);  //获取文章
        }
        return "front/index";
    }

    //添加文章,,需要登录认证
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addArticle(Article article){
        User user =  userService.getUserByName(String.valueOf(SecurityUtils.getSubject().getPrincipal()));  //查询当前用户的id
        article.setUser_id(user.getUser_id());  //获取用户id
        article.setArticle_date(new Date());  //添加文章当前日期
        System.out.println(article);  //输出
        articleService.addArticle(article);  //执行添加
        Integer article_id = article.getArticle_id();
        Map<String,Integer> map = new HashedMap();
        map.put("article_id",article_id);
        map.put("sort_id",article.getSort_id());
        if(sortService.addSet_article_sort(map)>=1){
            System.out.println("add success****************8");
        };
        System.out.println(article_id);
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
