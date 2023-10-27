package com.example.musicmservice.Service;

import com.example.musicmservice.Entities.Blog;
import com.example.musicmservice.Repository.IBlogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo blogRepo;
    @Override
    public Blog addBlog(Blog blog) {
      return blogRepo.save(blog);
    }

    @Override
    public void removeBlog(Integer idblog) {
    blogRepo.deleteById(idblog);
    }

    @Override
    public Blog editBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    public List<Blog> display() {
        return (List<Blog>) blogRepo.findAll();
    }

    @Override
    public Blog findbyid(Integer id) {
        return blogRepo.findById(id).get();
    }

}
