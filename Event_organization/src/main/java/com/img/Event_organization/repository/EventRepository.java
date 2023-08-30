package com.img.Event_organization.repository;

import com.img.Event_organization.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {


}
