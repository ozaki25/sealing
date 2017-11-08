package com.example.sealing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sealing.service.DailyRequestService;

@Controller
@RequestMapping("/daily_requests")
public class DailyRequestController {
    @Autowired
    private DailyRequestService DailyRequestService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("dailyRequests", DailyRequestService.findAll());
        return "daily_requests/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("dailyRequest", DailyRequestService.findOne(id));
        return "daily_requests/show";
    }
}
