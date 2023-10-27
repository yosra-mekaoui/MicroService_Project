package com.example.eventmanagement.Repository;
import com.example.eventmanagement.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket,Integer> {


}
