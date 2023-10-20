package com.img.Event_organization.service;

import com.img.Event_organization.entity.Referee;

import java.util.List;

public interface RefereeService {

    Referee addReferee(Referee referee);

    List<Referee> listOfReferees();

    void removeReferee(int referee_id);

    Referee updateRefereeEvent_id(int referee_id,int event_id);

    Referee updateRefereeName(int referee_id,String referee_Name);
}
