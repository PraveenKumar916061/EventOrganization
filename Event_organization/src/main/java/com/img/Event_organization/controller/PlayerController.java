package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;
import com.img.Event_organization.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/register")
    public Player registerPlayer(@RequestBody Player player) throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException , CollegeNotAllowedException {
        return playerService.registerPlayer(player);
    }

    @DeleteMapping("/delete/{player-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String removePlayer(@PathVariable("player-id") int player_id) {
        playerService.removePlayer(player_id);
        return player_id+" Player successfully removed";
    }

    @PutMapping("/update-email/{player-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Player updatePlayerEmail(@PathVariable("player-id") int player_id,@RequestParam("email") String email) throws InvalidEmailException{
        return playerService.updatePlayerEmail(player_id,email);
    }

    @GetMapping("/players/{team-id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Player> teamPlayerList(@PathVariable("team-id") int team_id) {
        return playerService.teamPlayerList(team_id);
    }

    @PutMapping("/update-phoneno/{player-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Player updatePlayerPhNo(@PathVariable("player-id") int player_id,@RequestParam String phone_no) throws InvalidMobileNumberException {
        return  playerService.updatePlayerPhNo(player_id,phone_no);
    }
}
