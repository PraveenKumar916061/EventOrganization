package com.img.Event_organization.service;

import com.img.Event_organization.entity.Points_Table;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PointsTableService {

    Points_Table addPointsForTeam(Points_Table pointsTable);

    List<Points_Table> getPointsTable();

    void deletePointsForTeam(int team_id);

    Points_Table updatePoints(int team_id,Points_Table points_table);

    List<Points_Table> top_3_InPointsTable();
}
