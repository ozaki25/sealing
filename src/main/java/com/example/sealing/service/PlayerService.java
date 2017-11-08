package com.example.sealing.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sealing.entity.Player;
import com.example.sealing.repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Transactional
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Transactional
    public Player findOne(Long id) {
        return playerRepository.findOne(id);
    }

    @Transactional
    public Player findByUserId(String userId) {
        return playerRepository.findByUserId(userId);
    }

    @Transactional
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Transactional
    public void delete(Long id) {
        playerRepository.delete(id);
    }

    @Transactional
    public void updatePassword(String userId, String password) {
        playerRepository.updatePassword(userId, password);
    }
}