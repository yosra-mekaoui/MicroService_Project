package com.example.musicmservice.Repository;



import com.example.musicmservice.Entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends CrudRepository<Comment, Integer> {
}
