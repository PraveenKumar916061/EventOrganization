package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Referee;
import com.img.Event_organization.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RefereeController {

    @Autowired
    private RefereeService refereeService;

    @PostMapping("/addReferee")
    public Referee addReferee(@RequestBody Referee referee) {
        return refereeService.addReferee(referee);
    }

    @GetMapping("/listOfReferees")
    public List<Referee> listOfReferees() {
        return refereeService.listOfReferees();
    }

    @DeleteMapping("/removeReferee/{referee_id}")
    public String removeReferee(@PathVariable("referee_id") int referee_id) {
        refereeService.removeReferee(referee_id);
        return referee_id+" referee deleted";
    }

    @PutMapping("/updateRefereeEventid/{referee_id}")
    public Referee updateRefereeEvent_id(@PathVariable("referee_id") int referee_id,@RequestParam("event_id") int event_id) {
        return refereeService.updateRefereeEvent_id(referee_id,event_id);
    }

    @PutMapping("/updateRefereeName/{referee_id}")
    public Referee updateRefereeName(@PathVariable("referee_id") int referee_id,@RequestParam("referee_Name") String referee_Name) {
        return refereeService.updateRefereeName(referee_id,referee_Name);
    }
}
