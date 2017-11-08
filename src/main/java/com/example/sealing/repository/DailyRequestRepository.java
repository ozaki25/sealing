package com.example.sealing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sealing.entity.DailyRequest;

@Repository
public interface DailyRequestRepository extends JpaRepository<DailyRequest, Long> {

}