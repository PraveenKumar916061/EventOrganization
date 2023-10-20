package com.img.Event_organization.controller;

import com.img.Event_organization.config.JWTService;
import com.img.Event_organization.security.AuthRequest;
import com.img.Event_organization.security.User_;
import com.img.Event_organization.security.User_DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private User_DetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    @PostMapping("/users")
    public ResponseEntity<?> user(@RequestBody User_ user) {
        userDetailsService.user(user);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Registered");
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated())
            return ResponseEntity.status(HttpStatus.OK).body(jwtService.generateToken(authRequest.getUsername()));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UsernameNotFoundException("Invalid username and password"));
    }
}
