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

import com.example.sealing.entity.DailyRequest;
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

    @GetMapping("new")
    public String newRequest(Model model) {
        model.addAttribute("dailyRequest", new DailyRequest());
        return "daily_requests/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("dailyRequest", DailyRequestService.findOne(id));
        return "daily_requests/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("dailyRequest", DailyRequestService.findOne(id));
        return "daily_requests/show";
    }

    @PostMapping
    public String create(@ModelAttribute DailyRequest dailyRequest) {
        DailyRequestService.save(dailyRequest);
        return "redirect:/daily_requests";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute DailyRequest dailyRequest) {
        dailyRequest.setId(id);
        DailyRequestService.save(dailyRequest);
        return "redirect:/daily_requests";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        DailyRequestService.delete(id);
        return "redirect:/daily_requests";
    }
}
