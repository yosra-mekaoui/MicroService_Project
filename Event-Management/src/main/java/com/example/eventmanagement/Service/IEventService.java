package com.example.eventmanagement.Service;

import com.example.eventmanagement.Entities.Event;

import java.util.List;

public interface IEventService {
    Event saveEvent(Event event);

    Event updateEvent(Integer idEvent, Event event);

    void deleteEvent(Integer idEvent);

    Event getEventById(Integer idEvent);

    List<Event> getAllEvents();

    //assigner des ticket à un event
    Event assignerTicketEvent(Integer idEvent, Integer idTicket);
}
