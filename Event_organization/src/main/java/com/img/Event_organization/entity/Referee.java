package com.img.Event_organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="referee")
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referee_id;
    private String referee_name;
    private int event_id;

    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "event_id",referencedColumnName = "event_id",insertable = false,updatable = false)
    private List<Event> events;

    @OneToMany(mappedBy = "referee")
    @JsonIgnore
    private List<Points_Table> pointsTable;

    public int getReferee_id() {
        return referee_id;
    }

    public void setReferee_id(int referee_id) {
        this.referee_id = referee_id;
    }

    public String getReferee_name() {
        return referee_name;
    }

    public void setReferee_name(String referee_name) {
        this.referee_name = referee_name;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Points_Table> getPointsTable() {
        return pointsTable;
    }

    public void setPointsTable(List<Points_Table> pointsTable) {
        this.pointsTable = pointsTable;
    }
}
