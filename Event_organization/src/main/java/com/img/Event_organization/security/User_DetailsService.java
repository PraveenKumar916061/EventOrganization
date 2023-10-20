package com.img.Event_organization.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Component
public class User_DetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User_> user=userRepository.findByUsername(username);
        return user.map(User_Details::new).orElseThrow(()->new UsernameNotFoundException("Invalid username"));
    }

    public void user(User_ user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}
