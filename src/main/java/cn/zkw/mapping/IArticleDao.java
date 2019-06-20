package cn.zkw.mapping;

import cn.zkw.vo.Article;

import java.util.List;

public interface IArticleDao {
    //文章添加
    Integer addArticle(Article article);

    //分页查询
    List<Article> splitArticle(Integer cp);

    //文章总数量
    Integer selectArticleAllNum();
}
