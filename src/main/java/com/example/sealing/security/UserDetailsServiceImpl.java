package com.example.sealing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.sealing.entity.Player;
import com.example.sealing.service.PlayerService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PlayerService service;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Player player = null;
        try {
            player = service.findByUserId(userId);
        } catch(Exception e) {
            throw new UsernameNotFoundException("It can not be acquired User");
        }

        if(player == null) throw new UsernameNotFoundException("User not found for login id: " + userId);
        return new LoginUser(player);
    }
}