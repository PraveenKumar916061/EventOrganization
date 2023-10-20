package com.img.Event_organization.service;

import com.img.Event_organization.entity.Referee;
import com.img.Event_organization.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeServiceImp implements RefereeService{

    @Autowired
    private RefereeRepository refereeRepository;
    @Override
    public Referee addReferee(Referee referee) {
        Referee referee_=new Referee();
        referee_.setReferee_name(referee.getReferee_name());
        referee_.setEvent_id(referee.getEvent_id());
        refereeRepository.save(referee_);
        return referee_;
    }

    @Override
    public List<Referee> listOfReferees() {
        return refereeRepository.findAll();
    }

    @Override
    public void removeReferee(int referee_id) {
        var referee=refereeRepository.findById(referee_id);
        if(referee.isPresent())
            refereeRepository.deleteById(referee_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," Referre id not found");
    }

    @Override
    public Referee updateRefereeEvent_id(int referee_id, int event_id) {
        Optional<Referee> referee=refereeRepository.findById(referee_id);
        if(referee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Referee id not found");
        Referee referee_=referee.get();
        referee_.setEvent_id(event_id);
        refereeRepository.save(referee_);

        return referee_;
    }

    @Override
    public Referee updateRefereeName(int referee_id, String referee_Name) {
        Optional<Referee> referee=refereeRepository.findById(referee_id);
        if(referee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Referee id not found");
        Referee referee_=referee.get();
        referee_.setReferee_name(referee_Name);
        refereeRepository.save(referee_);
        return referee_;
    }
}
