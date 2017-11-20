package com.example.sealing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sealing.service.SampleService;

@RestController
public class SampleController {
    @Autowired
    private SampleService service;

    @GetMapping("/sample")
    public String sample() {
        return service.getUsername();
    }

}
