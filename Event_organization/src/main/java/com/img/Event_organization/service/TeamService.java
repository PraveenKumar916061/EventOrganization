package com.img.Event_organization.service;

import com.img.Event_organization.entity.Team;

import java.util.List;

public interface TeamService {

    Team teamRegister(Team team);

    List<Team> listOfTeams();

    void removeTeam(int team_id);

    Team updateEventForTeam(int team_id,int event_id);
}
