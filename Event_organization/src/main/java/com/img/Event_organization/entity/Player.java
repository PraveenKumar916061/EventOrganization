package com.img.Event_organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int player_id;
    private String player_name;
    private int age;
    private String college_name;
    private String phone_no;
    private String email;
    private int team_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;

    public Player(String player_name, int age, String college_name, String phone_no, String email, int team_id) {
        this.player_name = player_name;
        this.age = age;
        this.college_name = college_name;
        this.phone_no = phone_no;
        this.email = email;
        this.team_id = team_id;
    }
}
