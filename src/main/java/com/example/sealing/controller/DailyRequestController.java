package com.example.sealing.controller;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sealing.service.DailyRequestService;
import com.example.sealing.type.StatusType;

@Controller
@RequestMapping("/daily_requests")
public class DailyRequestController {
    @Autowired
    private DailyRequestService dailyRequestService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("dailyRequests", dailyRequestService.findAll());
        return "daily_requests/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("dailyRequest", dailyRequestService.findOne(id));
        return "daily_requests/show";
    }

    @PutMapping("{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String action, RedirectAttributes attributes) {
        Integer nextStatusValue = StatusType.getNextStatusTypeByAction(action).getValue();
        dailyRequestService.updateStatus(id, nextStatusValue);
        attributes.addFlashAttribute("successMessage", "更新が完了しました");
        return "redirect:/daily_requests";
    }
}
*/