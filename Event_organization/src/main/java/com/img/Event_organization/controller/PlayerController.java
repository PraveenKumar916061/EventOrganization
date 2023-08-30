package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;
import com.img.Event_organization.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/registerPlayer")
    public Player registerPlayer(@RequestBody Player player) throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException , CollegeNotAllowedException {
        return playerService.registerPlayer(player);
    }

    @DeleteMapping("/removePlayer/{player_id}")
    public String removePlayer(@PathVariable("player_id") int player_id) {
        playerService.removePlayer(player_id);
        return player_id+" Player successfully removed";
    }

    @PutMapping("/updatePlayerEmail/{player_id}")
    public Player updatePlayerEmail(@PathVariable("player_id") int player_id,@RequestParam("email") String email) throws InvalidEmailException{
        return playerService.updatePlayerEmail(player_id,email);
    }

    @GetMapping("/listOfTeamPlayers/{team_id}")
    public List<Player> teamPlayerList(@PathVariable("team_id") int team_id) {
        return playerService.teamPlayerList(team_id);
    }

    @PutMapping("/updatePlayerPhno/{player_id}")
    public Player updatePlayerPhNo(@PathVariable("player_id") int player_id,@RequestParam("phone_no") String phone_no) throws InvalidMobileNumberException {
        return  playerService.updatePlayerPhNo(player_id,phone_no);
    }
}
