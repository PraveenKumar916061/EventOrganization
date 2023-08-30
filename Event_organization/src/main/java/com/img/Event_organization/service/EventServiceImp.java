package com.img.Event_organization.service;

import com.img.Event_organization.entity.Event;
import com.img.Event_organization.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements EventService{

    @Autowired
    private EventRepository eventRepository;


    @Override
    public Event eventRegister(Event event) {
        Event event_=new Event();
        event_.setEvent_name(event.getEvent_name());
        event_.setOrg_name(event.getOrg_name());
        event_.setDescription(event.getDescription());
        eventRepository.save(event_);
        return event_;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void removeEvent(int event_id) {
         eventRepository.deleteById(event_id);
    }

    @Override
    public Event updateEventName(String eventname,int eventid) {
        Event event=eventRepository.findById(eventid).get();
        event.setEvent_name(eventname);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event updateEventDescription(String description,int eventid) {
        Event event=eventRepository.findById(eventid).get();
        event.setDescription(description);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event updateOrganizationName(String org_name,int eventid) {
        Event event=eventRepository.findById(eventid).get();
        event.setOrg_name(org_name);
        eventRepository.save(event);
        return event;
    }

}
