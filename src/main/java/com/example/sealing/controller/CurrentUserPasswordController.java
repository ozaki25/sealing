package com.example.sealing.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String update(Principal principal, RedirectAttributes attributes, @RequestParam String password, @RequestParam String passwordConfirm) {
        String userId = principal.getName();
        playerService.updatePassword(userId, password);
        attributes.addFlashAttribute("successMessage", "パスワードを更新しました");
        return "redirect:/home";
    }
}
