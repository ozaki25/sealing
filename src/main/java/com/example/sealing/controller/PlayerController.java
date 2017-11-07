package com.example.sealing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sealing.entity.Player;
import com.example.sealing.service.PlayerService;
import com.example.sealing.type.RoleType;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "players/index";
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("roles", RoleType.values());
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findOne(id));
        model.addAttribute("roles", RoleType.values());
        return "players/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findOne(id));
        return "players/show";
    }

    @PostMapping
    public String create(@ModelAttribute Player player) {
        playerService.save(player);
        return "redirect:/players";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Player player) {
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/players";
    }
}
