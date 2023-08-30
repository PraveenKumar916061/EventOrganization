package com.img.Event_organization.service;

import com.img.Event_organization.entity.Event;

import java.util.List;

public interface EventService {

    Event eventRegister(Event event);

    List<Event> getEvents();

    void removeEvent(int event_id);

    Event updateEventName(String eventname,int eventid);

    Event updateEventDescription(String description,int eventid);

    Event updateOrganizationName(String org_name, int eventid);

}
