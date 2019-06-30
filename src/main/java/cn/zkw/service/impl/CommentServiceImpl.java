package cn.zkw.service.impl;

import cn.zkw.mapping.ICommentDao;
import cn.zkw.service.CommentService;
import cn.zkw.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    ICommentDao dao;

    @Override
    public List<Comment> selectCommentByArticleId(Integer article_id) {
        return dao.selectCommentByArticleId(article_id);
    }

    @Override
    public boolean addComment(Comment comment) {
        return dao.insertComment(comment)>=1;
    }
}
