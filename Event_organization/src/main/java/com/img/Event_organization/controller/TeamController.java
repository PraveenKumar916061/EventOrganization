package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Team;
import com.img.Event_organization.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/teamregister")
    public Team teamRegister(@RequestBody Team team) {
       return teamService.teamRegister(team);
    }

    @GetMapping("/getTeams")
    public List<Team> listOfTeams() {
        return teamService.listOfTeams();
    }

    @DeleteMapping("/removeteam/{teamid}")
    public String removeTeam(@PathVariable("teamid") int team_id) {
        teamService.removeTeam(team_id);
        return team_id+" data deleted";
    }

    @PutMapping("/updateEvent/{team_id}")
    public Team updateEventForTeam(@PathVariable("team_id") int team_id,@RequestParam("event_id") int event_id) {
        return teamService.updateEventForTeam(team_id,event_id);
    }
}
