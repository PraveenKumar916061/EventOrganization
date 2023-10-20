package com.img.Event_organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="points_table")
public class Points_Table{

    @Id
    private int team_id;
    private int referee_id;
    private int round_1;
    private int round_2;
    private int round_3;
    private double avg_points;

    @OneToOne
    @JoinColumn(name="team_id",insertable = false,updatable = false)
    @JsonIgnore
    private Team team_;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="referee_id",insertable = false,updatable = false)
    private Referee referee;
}
