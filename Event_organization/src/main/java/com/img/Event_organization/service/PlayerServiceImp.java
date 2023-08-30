package com.img.Event_organization.service;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;
import com.img.Event_organization.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PlayerServiceImp implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    private static final Logger logger= LoggerFactory.getLogger(PlayerServiceImp.class);
    Pattern pattern1=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail.com");
    Pattern pattern2=Pattern.compile("(0|91)?[6-9][0-9]{9}");

    public Player registerPlayer(Player player) throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException , CollegeNotAllowedException {
        int count=0;
        String collegename=null;
        List<Player> players=playerRepository.findAll();
        for(var v: players){
            if(v.getTeam_id()==player.getTeam_id()) {
                count++;
                collegename = v.getCollege_name();
            }
        }
        if(count<5) {
            Player player_ = new Player();
            player_.setPlayer_name(player.getPlayer_name());
            player_.setAge(player.getAge());
            if(count==0)
                player_.setCollege_name(player.getCollege_name());
            else {
                if (player.getCollege_name().equalsIgnoreCase(collegename))
                    player_.setCollege_name(player.getCollege_name());
                else
                    throw new CollegeNotAllowedException("Your are not allowed..  u are from different college");
            }
            Matcher matcher2 = pattern2.matcher(player.getPhone_no());
            if (matcher2.matches())
                player_.setPhone_no(player.getPhone_no());
            else
                throw new InvalidMobileNumberException("Invalid mobile Number Pls..! enter correct mobile number.......");
            Matcher matcher1 = pattern1.matcher(player.getEmail());
            if (matcher1.matches())
                player_.setEmail(player.getEmail());
            else
                throw new InvalidEmailException("Invalid email Pls...! enter correct email");
            player_.setTeam_id(player.getTeam_id());
            playerRepository.save(player_);
            return player_;
        }
        else
            throw new AlreadyTeamFilledException("Already team filled... can't add in this team");
    }

    @Override
    public void removePlayer(int player_id) {
        Optional<Player> player=playerRepository.findById(player_id);
        if(player.isPresent())
             playerRepository.deleteById(player_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Player Id");
    }

    @Override
    public Player updatePlayerEmail(int player_id,String email) throws InvalidEmailException{
        Optional<Player> player=playerRepository.findById(player_id);
        if(player.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not found");
        Player player_=player.get();
        Matcher matcher=pattern1.matcher(email);
        if(matcher.matches())
            player_.setEmail(email);
        else
            throw new InvalidEmailException("Invalid email"+email);
        playerRepository.save(player_);
        return player_;
    }

    @Override
    public List<Player> teamPlayerList(int team_id) {
        return playerRepository.teamPlayerList(team_id);
    }

    @Override
    public Player updatePlayerPhNo(int player_id, String phone_no) throws InvalidMobileNumberException {
        Optional<Player> player_ =playerRepository.findById(player_id);
        if(player_.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not found");
        Player player=player_.get();
        Matcher matcher=pattern2.matcher(phone_no);
        if(matcher.matches())
            player.setPhone_no(phone_no);
        else
            throw new InvalidMobileNumberException("Invalid mobile Number Pls..! enter correct mobile number.......");
        playerRepository.save(player);
        return player;
    }
}
