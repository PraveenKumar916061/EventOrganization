package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Points_Table;
import com.img.Event_organization.service.PointsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points-table")
public class PointsTableController {

    @Autowired
    private PointsTableService pointsTableService;

    @PostMapping("/register")
    public Points_Table addPointsForTeam(@RequestBody Points_Table pointsTable) {
        return pointsTableService.addPointsForTeam(pointsTable);
    }

    @GetMapping("/points")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Points_Table> getPointsTable() {
        return pointsTableService.getPointsTable();
    }

    @DeleteMapping("/delete/{team-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String deletePointsForTeam(@PathVariable("team-id") int team_id) {
        pointsTableService.deletePointsForTeam(team_id);
        return team_id + " deleted int points table";
    }

    @PutMapping("/update/{team-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Points_Table updatePoints(@PathVariable("team-id") int team_id, @RequestBody Points_Table points_Table) {
        return pointsTableService.updatePoints(team_id, points_Table);
    }

    @GetMapping("/top-3-in-Points-Table")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Points_Table> getTop3InPointsTable() {
        return pointsTableService.top_3_InPointsTable();
    }
}
