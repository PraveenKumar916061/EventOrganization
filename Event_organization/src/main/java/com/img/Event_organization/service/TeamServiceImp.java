package com.img.Event_organization.service;

import com.img.Event_organization.entity.Team;
import com.img.Event_organization.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImp implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team teamRegister(Team team) {
        Team t=new Team();
        t.setTeam_name(team.getTeam_name());
        t.setDescription(team.getDescription());
        t.setEvent_id(team.getEvent_id());
        teamRepository.save(t);
        return t;
    }

    @Override
    public List<Team> listOfTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void removeTeam(int team_id) {
        var team=teamRepository.findById(team_id);
        if(team.isPresent())
            teamRepository.deleteById(team_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
    }

    @Override
    public Team updateEventForTeam(int team_id, int event_id) {
        Optional<Team> team=teamRepository.findById(team_id);
        if(team.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Team id not found");
        Team team_=team.get();
        team_.setEvent_id(event_id);
        teamRepository.save(team_);
        return team_;
    }
}
