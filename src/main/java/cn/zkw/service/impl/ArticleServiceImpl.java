package cn.zkw.service.impl;

import cn.zkw.mapping.IArticleDao;
import cn.zkw.service.ArticleService;
import cn.zkw.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public IArticleDao dao;

    @Override
    public boolean addArticle(Article article) {
        System.out.println(dao);
        return dao.addArticle(article)>=1;
    }
}
