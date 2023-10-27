package com.example.eventmanagement.Service;
import com.example.eventmanagement.Repository.IEventRepository;
import com.example.eventmanagement.Repository.ITicketRepository;
import com.example.eventmanagement.Entities.Ticket;
import com.example.eventmanagement.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketService implements  ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private IEventRepository eventRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Integer idTicket, Ticket ticket) {
        Ticket tickett = ticketRepository.findById(idTicket).get();
        if (tickett != null) {
            tickett.setPrix(ticket.getPrix());
            tickett.setDateAchat(ticket.getDateAchat());
            tickett.setEvent(ticket.getEvent());
            return ticketRepository.save(tickett);
        }
        return null;
    }

    @Override
    public void deleteTicket(Integer idTicket) {
        ticketRepository.deleteById(idTicket);
    }

    @Override
    public Ticket getTicketById(Integer idEvent) {
        return ticketRepository.findById(idEvent).get();
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket addTicketToEvent(Integer IdEvent, Ticket ticket) {
        Event event = eventRepository.findById(IdEvent).orElse(null);
        if (event != null) {
            ticket.setEvent(event);
            ticket = ticketRepository.save(ticket);
            event.getTickets().add(ticket);
            eventRepository.save(event);
            return ticket;
        }
        return null;
    }

}
