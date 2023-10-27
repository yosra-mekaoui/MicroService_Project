package com.example.musicmservice.Controller;


import com.example.musicmservice.Entities.Blog;
import com.example.musicmservice.Service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BlogController {
    private final IBlogService iBlogService;

    @GetMapping("/all")
    @ResponseBody
    public List<Blog> getBlogs(){
        return iBlogService.display();
    }
    @PostMapping("/add")
    public Blog addBlog(@RequestBody Blog blog){
        return iBlogService.addBlog(blog);
    }
    @PutMapping ("/update")
    public Blog updateBlog(@RequestBody Blog blog){
        return iBlogService.editBlog(blog);
    }
    @GetMapping("/get/{id-blog}")
public Blog findbyid(@PathVariable("id-blog") Integer id ){
        return iBlogService.findbyid(id);
    }
    @DeleteMapping("/remove/{id-blog}")
    public void deleteblog(@PathVariable("id-blog") Integer id ){
       iBlogService.removeBlog(id);
    }
}
