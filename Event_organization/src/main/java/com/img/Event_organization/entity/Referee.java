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
@Table(name = "referee")
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referee_id;
    private String referee_name;
    private int event_id;

    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    private List<Event> events;

    @OneToMany(mappedBy = "referee")
    @JsonIgnore
    private List<Points_Table> pointsTable;

}
