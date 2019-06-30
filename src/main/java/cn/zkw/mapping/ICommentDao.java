package cn.zkw.mapping;

import cn.zkw.vo.Comment;

import java.util.List;

public interface ICommentDao {
    public List<Comment> selectCommentByArticleId(Integer article_id);

    public Integer insertComment(Comment comment);
}
