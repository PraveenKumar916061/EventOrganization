package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Event;
import com.img.Event_organization.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/register")
    public Event eventRegister(@RequestBody Event event) {
        return eventService.eventRegister(event);
    }

    @GetMapping("/events")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    
    @DeleteMapping("/delete/{event-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String removeEvent(@PathVariable("event-id") int event_id) {
        eventService.removeEvent(event_id);
        return event_id + " data deleted";
    }

    @PutMapping("/update-Event-Name/{event-name}/{event-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Event updateEventName(@PathVariable("event-name") String eventname, @PathVariable("event-id") int eventid) {
        return eventService.updateEventName(eventname, eventid);
    }

    @PutMapping("/update-Event-Description/{description}/{event-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Event updateEventDescription(@PathVariable("description") String description, @PathVariable("event-id") int eventid) {
        return eventService.updateEventDescription(description, eventid);
    }

    @PutMapping("/update-Organization-Name/{event-id}/{org-name}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Event updateOrganizationName(@PathVariable("event-id") int eventid, @PathVariable("org-name") String org_name) {
        return eventService.updateOrganizationName(org_name, eventid);
    }
}
