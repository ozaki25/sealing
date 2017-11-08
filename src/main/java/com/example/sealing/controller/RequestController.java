package com.example.sealing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sealing.entity.Request;
import com.example.sealing.service.RequestService;

@Controller
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping("new")
    public String newRequest(Model model) {
        model.addAttribute("request", new Request());
        return "requests/new";
    }

    @PostMapping
    public String create(@ModelAttribute Request request) {
        requestService.save(request);
        return "redirect:/home";
    }
}
