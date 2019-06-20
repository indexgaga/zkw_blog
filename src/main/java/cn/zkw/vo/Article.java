package cn.zkw.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章类
 */
@Component
public class Article implements Serializable {
    private Integer article_id;         //文章id
    private Integer user_id;             //发表文章的用户id
    private String article_title;       //文章标题
    private Integer article_views;      //浏览量
    private Integer article_comment_count;  //评论数
    private String article_content;     //文章内容
    private String article_keyword;     //文章关键字字符串集,逗号分隔
    private String article_describe;    //文章介绍
    private String sort_id;             //分类id
    private String label_name;          //标签名字符串集,逗号分隔
    private Date article_date;          //发布时间
    private Integer article_like_count; //点赞数量
    private Integer article_ispublic;   //是否公开,默认为1(公开)
    private String article_img;         //文章图片

    public Integer getArticle_id() {
        return article_id;
    }

    public Integer getArticle_views() {
        return article_views;
    }

    public void setArticle_views(Integer article_views) {
        this.article_views = article_views;
    }

    public Integer getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(Integer article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_keyword() {
        return article_keyword;
    }

    public void setArticle_keyword(String article_keyword) {
        this.article_keyword = article_keyword;
    }

    public String getArticle_describe() {
        return article_describe;
    }

    public void setArticle_describe(String article_describe) {
        this.article_describe = article_describe;
    }

    public String getSort_id() {
        return sort_id;
    }

    public void setSort_id(String sort_id) {
        this.sort_id = sort_id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public Date getArticle_date() {
        return article_date;
    }

    public void setArticle_date(Date article_date) {
        this.article_date = article_date;
    }

    public Integer getArticle_like_count() {
        return article_like_count;
    }

    public void setArticle_like_count(Integer article_like_count) {
        this.article_like_count = article_like_count;
    }

    public Integer getArticle_ispublic() {
        return article_ispublic;
    }

    public void setArticle_ispublic(Integer article_ispublic) {
        this.article_ispublic = article_ispublic;
    }

    public String getArticle_img() {
        return article_img;
    }

    public void setArticle_img(String article_img) {
        this.article_img = article_img;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", user_id=" + user_id +
                ", article_content='" + article_content + '\'' +
                ", article_title='" + article_title + '\'' +
                ", article_keyword='" + article_keyword + '\'' +
                ", article_describe='" + article_describe + '\'' +
                ", sort_id='" + sort_id + '\'' +
                ", label_name='" + label_name + '\'' +
                ", article_date=" + article_date +
                ", article_like_count=" + article_like_count +
                ", article_ispublic=" + article_ispublic +
                ", article_img='" + article_img + '\'' +
                '}';
    }
}
