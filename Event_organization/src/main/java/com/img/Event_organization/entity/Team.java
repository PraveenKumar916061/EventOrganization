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
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;
    private String team_name;
    private int event_id;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private Event event;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Player> players;

    @OneToOne(mappedBy = "team_")
    @JsonIgnore
    private Points_Table pointsTable;
}
