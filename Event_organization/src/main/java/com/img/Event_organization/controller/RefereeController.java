package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Referee;
import com.img.Event_organization.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/referee")
public class RefereeController {

    @Autowired
    private RefereeService refereeService;

    @PostMapping("/register")
    public Referee addReferee(@RequestBody Referee referee) {
        return refereeService.addReferee(referee);
    }

    @GetMapping("/referees")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Referee> listOfReferees() {
        return refereeService.listOfReferees();
    }

    @DeleteMapping("/delete/{referee-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String removeReferee(@PathVariable("referee-id") int referee_id) {
        refereeService.removeReferee(referee_id);
        return referee_id + " referee deleted";
    }

    @PutMapping("/update-event-id/{referee-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Referee updateRefereeEvent_id(@PathVariable("referee-id") int referee_id, @RequestParam int event_id) {
        return refereeService.updateRefereeEvent_id(referee_id, event_id);
    }

    @PutMapping("/updater-referee-name/{referee-id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Referee updateRefereeName(@PathVariable("referee-id") int referee_id, @RequestParam String referee_Name) {
        return refereeService.updateRefereeName(referee_id, referee_Name);
    }
}
