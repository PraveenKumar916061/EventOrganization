package com.img.Event_organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

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

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getReferee_id() {
        return referee_id;
    }

    public void setReferee_id(int referee_id) {
        this.referee_id = referee_id;
    }

    public int getRound_1() {
        return round_1;
    }

    public void setRound_1(int round_1) {
        this.round_1 = round_1;
    }

    public int getRound_2() {
        return round_2;
    }

    public void setRound_2(int round_2) {
        this.round_2 = round_2;
    }

    public int getRound_3() {
        return round_3;
    }

    public void setRound_3(int round_3) {
        this.round_3 = round_3;
    }

    public double getAvg_points() {
        return avg_points;
    }

    public void setAvg_points(double avg_points) {
        this.avg_points = avg_points;
    }

    public Team getTeam_() {
        return team_;
    }

    public void setTeam_(Team team_) {
        this.team_ = team_;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
