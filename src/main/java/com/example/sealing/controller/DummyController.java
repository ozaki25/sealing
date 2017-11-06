package com.example.sealing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sealing.entity.Player;
import com.example.sealing.service.PlayerService;

@Controller
@RequestMapping("/dummy/players")
public class DummyController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "dummy/players/index";
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        model.addAttribute("player", new Player());
        return "dummy/players/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findOne(id));
        return "dummy/players/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findOne(id));
        return "dummy/players/show";
    }

    @PostMapping
    public String create(@ModelAttribute Player player, BindingResult bindingResult) {
        try {
            playerService.save(player);
        } catch(Exception e) {
            bindingResult.rejectValue("userId", "500", e.toString());
            return "dummy/players/new";
        }
        return "redirect:/dummy/players";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Player player, BindingResult bindingResult) {
        try {
            player.setId(id);
            playerService.save(player);
        } catch(Exception e) {
            bindingResult.rejectValue("userId", "500", e.toString());
            return "dummy/players/edit";
        }
        return "redirect:/dummy/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/dummy/players";
    }
}
