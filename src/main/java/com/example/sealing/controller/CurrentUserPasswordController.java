package com.example.sealing.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sealing.service.PlayerService;

@Controller
@RequestMapping("/current_user/password")
public class CurrentUserPasswordController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/edit")
    public String edit() {
        return "current_user/password/edit";
    }

    @PatchMapping
    public String update(Principal principal, @RequestParam String password, @RequestParam String passwordConfirm) {
        String userId = principal.getName();
        playerService.updatePassword(userId, password);
        return "redirect:/home";
    }
}
