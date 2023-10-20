package com.img.Event_organization.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User_,Integer> {
    Optional<User_> findByUsername(String username);
}
