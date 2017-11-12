package com.example.sealing.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sealing.entity.DailyRequest;

@Repository
public interface DailyRequestRepository extends JpaRepository<DailyRequest, Long> {

    DailyRequest findByDate(Date date);

    @Modifying
    @Query("update DailyRequest set statusType = ?2 where id = ?1")
    void updateStatus(Long id, Integer statusType);

}
