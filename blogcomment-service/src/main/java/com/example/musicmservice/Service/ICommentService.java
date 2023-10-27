package com.example.musicmservice.Service;

import com.example.musicmservice.Entities.Blog;
import com.example.musicmservice.Entities.Comment;

import java.util.List;

public interface ICommentService {
   Comment addComment(Comment comment);
   void removeComment(Integer id);
   Comment editComment(Comment comment);
   List<Comment> display();
   Comment findbyid(Integer id);
   public Comment addCommentToBlog(Integer blogId, Comment comment);
   public List<Comment> getCommentsForBlog(Integer blogId);
   public void removeCommentFromBlog(Integer blogId, Integer commentId);
}
