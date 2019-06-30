package cn.zkw.service;

import cn.zkw.vo.Comment;
import cn.zkw.vo.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CommentService {
    public List<Comment> selectCommentByArticleId(Integer article_id);

    public boolean addComment(Comment comment);
}
