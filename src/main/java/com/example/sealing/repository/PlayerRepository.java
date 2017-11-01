package com.example.sealing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sealing.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}