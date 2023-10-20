package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Team;
import com.img.Event_organization.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/register")
    public Team teamRegister(@RequestBody Team team) {
        return teamService.teamRegister(team);
    }

    @GetMapping("/teams")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Team> listOfTeams() {
        return teamService.listOfTeams();
    }

    @DeleteMapping("/delete/{team-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String removeTeam(@PathVariable("team-id") int team_id) {
        teamService.removeTeam(team_id);
        return team_id + " data deleted";
    }

    @PutMapping("/update/{team-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Team updateEventForTeam(@PathVariable("team-id") int team_id, @RequestParam int event_id) {
        return teamService.updateEventForTeam(team_id, event_id);
    }
}
