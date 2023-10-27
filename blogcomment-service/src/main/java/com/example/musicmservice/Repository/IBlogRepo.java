package com.example.musicmservice.Repository;

import com.example.musicmservice.Entities.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends CrudRepository<Blog, Integer> {

}
