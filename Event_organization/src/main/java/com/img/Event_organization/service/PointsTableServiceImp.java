package com.img.Event_organization.service;

import com.img.Event_organization.entity.Points_Table;
import com.img.Event_organization.repository.PointsTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PointsTableServiceImp implements PointsTableService{

    @Autowired
    private PointsTableRepository pointsTableRepository;

    @Override
    public Points_Table addPointsForTeam(Points_Table pointsTable) {
        Points_Table points_table=new Points_Table();
        points_table.setTeam_id(pointsTable.getTeam_id());
        points_table.setReferee_id(pointsTable.getReferee_id());
        points_table.setRound_1(pointsTable.getRound_1());
        points_table.setRound_2(pointsTable.getRound_2());
        points_table.setRound_3(pointsTable.getRound_3());
        double avg=(pointsTable.getRound_1()+pointsTable.getRound_2()+pointsTable.getRound_3())/3;
        points_table.setAvg_points(avg);
        pointsTableRepository.save(points_table);
        return points_table;
    }

    @Override
    public List<Points_Table> getPointsTable() {
        return pointsTableRepository.findAll();
    }

    @Override
    public void deletePointsForTeam(int team_id) {
        Optional<Points_Table> pointsTable =pointsTableRepository.findById(team_id);
        if(pointsTable.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid team id or id not found");
        pointsTableRepository.deleteById(team_id);
    }

    @Override
    public Points_Table updatePoints(int team_id,Points_Table points_Table) {
        Optional<Points_Table> pointsTable =pointsTableRepository.findById(team_id);
        if(pointsTable.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid team id or id not found");
        Points_Table points_table=pointsTable.get();
        points_table.setRound_1(points_Table.getRound_1());
        points_table.setRound_2(points_Table.getRound_2());
        points_table.setRound_3(points_Table.getRound_3());
        double avg=(points_Table.getRound_1()+points_Table.getRound_2()+points_Table.getRound_3())/3;
        System.out.println(avg);
        points_table.setAvg_points(avg);
        pointsTableRepository.save(points_table);
        return points_table;
    }

    @Override
    public List<Points_Table> top_3_InPointsTable() {
        var pointsTables=pointsTableRepository.getTop3InPointsTable();
        return pointsTables.stream().limit(3).collect(Collectors.toList());
    }
}
