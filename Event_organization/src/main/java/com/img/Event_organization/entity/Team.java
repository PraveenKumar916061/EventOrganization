package com.img.Event_organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;
    private String team_name;
    private int event_id;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="event_id",insertable = false,updatable = false)
    private Event event;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Player> players;

    @OneToOne(mappedBy = "team_")
    @JsonIgnore
    private Points_Table pointsTable;

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Points_Table getPointsTable() {
        return pointsTable;
    }

    public void setPointsTable(Points_Table pointsTable) {
        this.pointsTable = pointsTable;
    }
}
