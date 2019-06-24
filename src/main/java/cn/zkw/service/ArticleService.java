package cn.zkw.service;

import cn.zkw.vo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    public Integer addArticle(Article article);

    public List<Article> splitArticle(Integer cp);

    public Integer getArticleAllNum();

    public List<Article> preSplitArticle(Integer num);

    public Article selectArticleById(Integer article_id);
}
