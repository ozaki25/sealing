package com.example.sealing.controller;

import javax.validation.Valid;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(@Valid @ModelAttribute Player player, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) return "players/new";
        playerService.save(player);
        attributes.addFlashAttribute("successMessage", "アカウントの作成が完了しました");
        return "redirect:/players";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Player player, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) return "players/edit";
        player.setId(id);
        playerService.update(player);
        attributes.addFlashAttribute("successMessage", "アカウントの更新が完了しました");
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id, RedirectAttributes attributes) {
        playerService.delete(id);
        attributes.addFlashAttribute("successMessage", "アカウントの削除が完了しました");
        return "redirect:/players";
    }
}
