package com.example.eventmanagement.Service;
import com.example.eventmanagement.Entities.Event;
import com.example.eventmanagement.Repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService implements IEventService {
    @Autowired
    private IEventRepository eventRepository;

    @Autowired
    private ITicketService ticketService;

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Integer idEvent, Event event) {
        Event eventt = eventRepository.findById(idEvent).get();
        if (eventt != null) {
            eventt.setNom(event.getNom());
            eventt.setLieu(event.getLieu());
            eventt.setDate(event.getDate());
            eventt.setArtiste(event.getArtiste());
            eventt.setDescription(event.getDescription());
            eventt.setTickets(event.getTickets());
            return eventRepository.save(eventt);
        }
        return null;
    }

    @Override
    public void deleteEvent(Integer idEvent) {
        eventRepository.deleteById(idEvent);
    }

    @Override
    public Event getEventById(Integer idEvent) {
        return eventRepository.findById(idEvent).get();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    //assigner des ticket à un event
    @Override
    public Event assignerTicketEvent(Integer idEvent, Integer idTicket) {
        Event event = eventRepository.findById(idEvent).get();
        if (event != null) {
            event.getTickets().add(ticketService.getTicketById(idTicket));
            return eventRepository.save(event);
        }
        return null;
    }

}

