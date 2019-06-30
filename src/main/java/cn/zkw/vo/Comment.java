package cn.zkw.vo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer comment_id;
    private Integer user_id;
    private Integer article_id;
    private String user_name;
    private Integer comment_like_count;
    private Date comment_date;
    private String comment_content;
    private Integer parent_comment_id;
    private String user_photo;

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getComment_like_count() {
        return comment_like_count;
    }

    public void setComment_like_count(Integer comment_like_count) {
        this.comment_like_count = comment_like_count;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", article_id=" + article_id +
                ", user_name='" + user_name + '\'' +
                ", comment_like_count=" + comment_like_count +
                ", comment_date=" + comment_date +
                ", comment_content='" + comment_content + '\'' +
                ", parent_comment_id=" + parent_comment_id +
                ", user_photo='" + user_photo + '\'' +
                '}';
    }
}
