package com.img.Event_organization.service;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;

import java.util.List;

public interface PlayerService {

    Player registerPlayer(Player player) throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException, CollegeNotAllowedException;

    void removePlayer(int player_id);

    Player updatePlayerEmail(int player_id,String email) throws InvalidEmailException;

    List<Player> teamPlayerList(int team_id);

    Player updatePlayerPhNo(int player_id,String phoneno) throws InvalidMobileNumberException;
}
