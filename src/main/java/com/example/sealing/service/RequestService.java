package com.example.sealing.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sealing.entity.DailyRequest;
import com.example.sealing.entity.Request;
import com.example.sealing.repository.RequestRepository;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private DailyRequestService dailyRequestService;

    @Transactional
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Transactional
    public Request findOne(Long id) {
        return requestRepository.findOne(id);
    }

    @Transactional
    public Request save(Request request) {
        DailyRequest dailyRequest = dailyRequestService.findByDate(request.getDate());
        if(dailyRequest == null) {
            dailyRequest = dailyRequestService.save(new DailyRequest(request.getDate()));
        }
        request.setDailyRequest(dailyRequest);
        return requestRepository.save(request);
    }

    @Transactional
    public void delete(Long id) {
        requestRepository.delete(id);
    }
}