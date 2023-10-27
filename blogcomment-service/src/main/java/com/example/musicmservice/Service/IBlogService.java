package com.example.musicmservice.Service;

import com.example.musicmservice.Entities.Blog;

import java.util.List;

public interface IBlogService {

    Blog addBlog(Blog blog);
    void removeBlog(Integer idblog);
    Blog editBlog(Blog blog);

    List<Blog> display();
    Blog findbyid(Integer id);

}
