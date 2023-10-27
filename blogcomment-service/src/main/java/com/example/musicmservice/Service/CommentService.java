package com.example.musicmservice.Service;

import com.example.musicmservice.Entities.Blog;
import com.example.musicmservice.Entities.Comment;
import com.example.musicmservice.Repository.IBlogRepo;
import com.example.musicmservice.Repository.ICommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepo commentRepo;
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public Comment addComment(Comment comment) {
        return  commentRepo.save(comment);
    }

    @Override
    public void removeComment(Integer id) {
      commentRepo.deleteById(id);
    }

    @Override
    public Comment editComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> display() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public Comment findbyid(Integer id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public Comment addCommentToBlog(Integer blogId, Comment comment) {
        Blog blog = blogRepo.findById(blogId).orElse(null);
        if (blog != null) {
            comment.setBlog(blog);
            comment = commentRepo.save(comment);
            // Add the comment to the blog's comments set
            blog.getComments().add(comment);
            // Update the blog
            blogRepo.save(blog);
            return comment;
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsForBlog(Integer blogId) {
        Blog blog = blogRepo.findById(blogId).orElse(null);
        if (blog != null) {
            List<Comment> comments = new ArrayList<>(blog.getComments());
            return comments;
        }
        return Collections.emptyList();
    }

    @Override
    public void removeCommentFromBlog(Integer blogId, Integer commentId) {
        Blog blog = blogRepo.findById(blogId).orElse(null);
        if (blog != null) {
            Comment comment = commentRepo.findById(commentId).orElse(null);
            if (comment != null && comment.getBlog().equals(blog)) {
                comment.setBlog(null); // Remove the association
                commentRepo.save(comment);
            }
        }
    }
}
