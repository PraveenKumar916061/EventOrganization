package com.img.Event_organization.repository;

import com.img.Event_organization.entity.Points_Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PointsTableRepository extends JpaRepository<Points_Table,Integer> {

    @Query("from Points_Table pt order by pt.avg_points DESC")
    List<Points_Table> getTop3InPointsTable();
}
