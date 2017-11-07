package com.example.sealing.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.sealing.entity.Player;
import com.example.sealing.type.RoleType;;

public class LoginUser extends User {
    private final Player player;
    private final String username;
    private final String password;

    public LoginUser(Player player) {
        super(player.getUserId(), player.getPassword(), AuthorityUtils.createAuthorityList(RoleType.getRoleTypeByValue(player.getRoleType()).getAuthority()));
        this.player = player;
        this.username = player.getUserId();
        this.password = player.getPassword();
    }

    public Player getPlayer() {
        return player;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
