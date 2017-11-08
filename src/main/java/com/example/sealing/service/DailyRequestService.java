package com.example.sealing.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sealing.entity.DailyRequest;
import com.example.sealing.repository.DailyRequestRepository;

@Service
public class DailyRequestService {
    @Autowired
    private DailyRequestRepository dailyRequestRepository;

    @Transactional
    public List<DailyRequest> findAll() {
        return dailyRequestRepository.findAll();
    }

    @Transactional
    public DailyRequest findOne(Long id) {
        return dailyRequestRepository.findOne(id);
    }

    @Transactional
    public DailyRequest save(DailyRequest dailyRequest) {
        return dailyRequestRepository.save(dailyRequest);
    }

    @Transactional
    public void delete(Long id) {
        dailyRequestRepository.delete(id);
    }
}