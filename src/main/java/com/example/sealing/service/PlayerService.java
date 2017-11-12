package com.example.sealing.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sealing.entity.Player;
import com.example.sealing.mapper.PlayerMapper;

@Service
public class PlayerService {
    @Autowired
    // private PlayerRepository playerRepository; // use jpa
    private PlayerMapper playerRepository; // use mybatis

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
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Transactional
    public void update(Player player) {
        // mybatisのsqlをxmlで書いたらここもjpaと統一化できそう
        // playerRepository.save(player);
        playerRepository.update(player);
    }

    @Transactional
    public void updatePassword(String userId, String password) {
        playerRepository.updatePassword(userId, password);
    }

    @Transactional
    public void delete(Long id) {
        playerRepository.delete(id);
    }
}