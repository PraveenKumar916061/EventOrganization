package com.img.Event_organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    private String event_name;
    private String org_name;
    private String description;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Team> teams;

    @ManyToMany(mappedBy = "events")
    @JsonIgnore
    private List<Referee> referees;

}
