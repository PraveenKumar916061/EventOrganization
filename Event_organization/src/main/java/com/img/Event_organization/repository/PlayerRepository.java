package com.img.Event_organization.repository;

import com.img.Event_organization.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

    @Query("from Player p where team_id=:id")
    List<Player> teamPlayerList(@Param("id") int id);
}
