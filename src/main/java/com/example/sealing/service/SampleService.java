package com.example.sealing.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.sealing.security.LoginUser;

@Service
public class SampleService {
    public String getUsername() {
        try {
            LoginUser user = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return user.getUsername();
        } catch(Exception e) {
            return "anonymous";
        }
    }
}
