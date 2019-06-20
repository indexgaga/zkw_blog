package cn.zkw.service;

import cn.zkw.vo.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    public boolean addArticle(Article article);
}
