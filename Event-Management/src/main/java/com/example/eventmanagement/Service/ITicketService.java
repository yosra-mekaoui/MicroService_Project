package com.example.eventmanagement.Service;

import com.example.eventmanagement.Entities.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket saveTicket(Ticket ticket);

    Ticket updateTicket(Integer idTicket ,Ticket ticket);

    void deleteTicket(Integer idTicket);

    Ticket getTicketById(Integer id);

    List<Ticket> getAllTickets();

    Ticket addTicketToEvent(Integer IdEvent, Ticket ticket);
}
