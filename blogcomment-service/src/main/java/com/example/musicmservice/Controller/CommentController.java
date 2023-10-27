package com.example.musicmservice.Controller;


import com.example.musicmservice.Entities.Comment;
import com.example.musicmservice.Service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService iCommentService;

    @GetMapping("/all")
    @ResponseBody
    public List<Comment> getcomment(){
        return iCommentService.display();
    }
    @PostMapping("/add")
    public Comment addComment(@RequestBody Comment comment){
        return iCommentService.addComment(comment);
    }
    @PutMapping ("/update")
    public Comment updateComment(@RequestBody Comment comment){
        return iCommentService.editComment(comment);
    }
    @GetMapping("/get/{id-comment}")
    public Comment findbyid(@PathVariable("id-comment") Integer id ){
        return iCommentService.findbyid(id);
    }
    @DeleteMapping("/remove/{id-comment}")
    public void deleteComment(@PathVariable("id-comment") Integer id ){
        iCommentService.removeComment(id);
    }

    @PostMapping("/{blogId}/comment")
    public Comment addCommentToBlog(@PathVariable Integer blogId, @RequestBody Comment comment) {
        return iCommentService.addCommentToBlog(blogId, comment);
    }
    @GetMapping("/{blogId}/comments")
    public List<Comment> getCommentsForBlog(@PathVariable Integer blogId) {
        return iCommentService.getCommentsForBlog(blogId);
    }
    @DeleteMapping("/{blogId}/comment/{commentId}")
    public void removeCommentFromBlog(@PathVariable Integer blogId, @PathVariable Integer commentId) {
        iCommentService.removeCommentFromBlog(blogId, commentId);
    }
}
