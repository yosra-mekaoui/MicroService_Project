package com.example.eventmanagement.Repository;
import com.example.eventmanagement.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IEventRepository extends JpaRepository<Event,Integer> {

}
