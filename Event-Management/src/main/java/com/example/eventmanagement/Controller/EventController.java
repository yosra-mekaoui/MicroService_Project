package com.example.eventmanagement.Controller;
import com.example.eventmanagement.Entities.Event;
import com.example.eventmanagement.Entities.Ticket;
import com.example.eventmanagement.Repository.IEventRepository;
import com.example.eventmanagement.Repository.ITicketRepository;
import com.example.eventmanagement.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/event")
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    private IEventService eventService;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IEventRepository eventRepository;
    @Autowired
    private ITicketRepository ticketRepository;

    @GetMapping(value="/getEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping(value="/getbyid/{idEvent}")
    public Event getEventById(@PathVariable Integer idEvent){
        return eventService.getEventById(idEvent);
    }

    @PostMapping(value="/addEvent")
    public Event addEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @PutMapping(value="/updateEvent/{idEvent}")
    public Event updateEvent(@PathVariable Integer idEvent, @RequestBody Event event){
        return eventService.updateEvent(idEvent,event);
    }

    @DeleteMapping(value="/deleteEvent/{idEvent}")
    public void deleteEvent(@PathVariable Integer idEvent){
        eventService.deleteEvent(idEvent);
    }

    //ticket
    @GetMapping(value="/getTickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping(value="/getTicketById/{idTicket}")
    public Ticket getTicketById(@PathVariable Integer idTicket){
        return ticketService.getTicketById(idTicket);
    }

    @PostMapping(value="/addTicket")
    public Ticket addTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }

    @PutMapping(value="/updateTicket/{idTicket}")
    public Ticket updateTicket(@PathVariable Integer idTicket, @RequestBody Ticket ticket){
        return ticketService.updateTicket(idTicket,ticket);
    }

    @DeleteMapping(value="/deleteTicket/{idTicket}")
    public void deleteTicket(@PathVariable Integer idTicket){
        ticketService.deleteTicket(idTicket);
    }
//assign

    @PutMapping(value="/assignerTicketEvent/{idEvent}/{idTicket}")
    public Event assignerTicketEvent(@PathVariable Integer idEvent, @PathVariable Integer idTicket){
        return eventService.assignerTicketEvent(idEvent,idTicket);
    }

    //addTicketToEvent
    @PutMapping(value="/addTicketToEvent/{idEvent}")
    public Ticket addTicketToEvent(@PathVariable Integer idEvent, @RequestBody Ticket ticket){
        return ticketService.addTicketToEvent(idEvent,ticket);
    }



}
