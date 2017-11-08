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

import com.example.sealing.entity.Request;
import com.example.sealing.service.RequestService;

@Controller
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("requests", requestService.findAll());
        return "requests/index";
    }

    @GetMapping("new")
    public String newRequest(Model model) {
        model.addAttribute("request", new Request());
        return "requests/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("request", requestService.findOne(id));
        return "requests/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("request", requestService.findOne(id));
        return "requests/show";
    }

    @PostMapping
    public String create(@ModelAttribute Request request) {
        requestService.save(request);
        return "redirect:/requests";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Request request) {
        request.setId(id);
        requestService.save(request);
        return "redirect:/requests";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        requestService.delete(id);
        return "redirect:/requests";
    }
}
