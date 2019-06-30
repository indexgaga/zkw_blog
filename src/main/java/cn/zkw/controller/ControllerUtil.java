package cn.zkw.controller;

import cn.zkw.service.ArticleService;
import cn.zkw.service.CommentService;
import cn.zkw.vo.Article;
import cn.zkw.vo.Comment;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControllerUtil {
    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;
    /**
     * 前台查看文章页面跳转
     * @param article_id
     * @param request
     * @return
     */
    @RequestMapping("/front/article")
    public String article(Integer article_id, HttpServletRequest request,Model model){
        request.getSession().setAttribute("article_id",article_id); //文章id
        Article article = articleService.selectArticleById(article_id); //查找文章
        request.getSession().setAttribute("article",article);
        model.addAttribute("article_content",article.getArticle_content()); //文章内容
        List<Comment> listComment = commentService.selectCommentByArticleId(article_id);
        System.out.println(listComment);
        model.addAttribute("listComment",listComment);
        return "front/article";
    }


    /**
     * 根据id查看文章接口
     */
    @RequestMapping(value = "/getArticle", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object getArticle(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Integer article_id =  (Integer)request.getSession().getAttribute("article_id");  //从/front/article中添加的article_id获取
        Article article =  articleService.selectArticleById(article_id);   //根据id查询文章
        jsonObject.put("article",article);
        jsonObject.put("article_content",article.getArticle_content());
        return jsonObject;
    }
}
