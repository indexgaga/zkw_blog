package cn.zkw.mapping;

import cn.zkw.vo.Article;

import java.util.List;

public interface IArticleDao {
    //文章添加
    Integer addArticle(Article article);

    //分页查询
    List<Article> splitArticle(Integer num);

    //文章总数量
    Integer selectArticleAllNum();

    //首页分页预览查询,num为查询的条数,以最新发布的文章开始排序
    List<Article> preSplitArticle(Integer num);

    //根据id查询文章
    Article selectArticleById(Integer article_id);
}
