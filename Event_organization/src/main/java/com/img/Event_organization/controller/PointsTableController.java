package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Points_Table;
import com.img.Event_organization.service.PointsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointsTableController {

    @Autowired
    private PointsTableService pointsTableService;

    @PostMapping("/addPoints")
    public Points_Table addPointsForTeam(@RequestBody Points_Table pointsTable) {
        return pointsTableService.addPointsForTeam(pointsTable);
    }

    @GetMapping("/getPointsTable")
    public List<Points_Table> getPointsTable() {
        return pointsTableService.getPointsTable();
    }

    @DeleteMapping("/deletePoints/{team_id}")
    public String deletePointsForTeam(@PathVariable("team_id") int team_id) {
        pointsTableService.deletePointsForTeam(team_id);
        return team_id+" deleted int points table";
    }

    @PutMapping("/updatePoints/{team_id}")
    public Points_Table updatePoints(@PathVariable("team_id") int team_id,@RequestBody Points_Table points_Table) {
        return pointsTableService.updatePoints(team_id,points_Table);
    }

    @GetMapping("/top3InPointsTable")
    public List<Points_Table> getTop3InPointsTable(){
        return pointsTableService.top_3_InPointsTable();
    }
}
