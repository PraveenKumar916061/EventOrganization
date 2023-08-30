package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Event;
import com.img.Event_organization.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/eventregister")
    public Event eventRegister(@RequestBody Event event){
       return eventService.eventRegister(event);
    }

    @GetMapping("/getEvents")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @DeleteMapping("/deleteEvent/{eventid}")
    public String removeEvent(@PathVariable("eventid") int event_id){
        eventService.removeEvent(event_id);
        return event_id+" data deleted";
    }

    @PutMapping("/updateEventName/{eventname}/{eventid}")
    public Event updateEventName(@PathVariable("eventname") String eventname,@PathVariable("eventid") int eventid) {
        return eventService.updateEventName(eventname,eventid);
    }

    @PutMapping("/updateEventDescription/{description}/{eventid}")
    public Event updateEventDescription(@PathVariable("description") String description,@PathVariable("eventid") int eventid) {
      return eventService.updateEventDescription(description,eventid);
    }

    @PutMapping("/updateOrganizationName/{eventid}/{org_name}")
    public Event updateOrganizationName(@PathVariable("eventid") int eventid,@PathVariable("org_name") String org_name) {
       return eventService.updateOrganizationName(org_name,eventid);
    }
}
