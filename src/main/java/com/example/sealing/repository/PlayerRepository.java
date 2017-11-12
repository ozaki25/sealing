package com.example.sealing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sealing.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByUserId(String userId);

    @Modifying
    @Query("update Player p set p.password = ?2 where user_id = ?1")
    void updatePassword(String userId, String password);

}
