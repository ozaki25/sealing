package com.example.sealing.bean;

import com.example.sealing.entity.Player;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;

@JsonPropertyOrder({"id", "name", "userId", "role"})
public class PlayerCsvBean {
    private Long id;
    private String name;
    @JsonRawValue
    private String userId;
    @JsonRawValue
    private String role;

    public PlayerCsvBean(Player p) {
        this.id = p.getId();
        this.name = p.getName();
        this.userId = p.getUserId();
        this.role = p.getRoleTypeLabel();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
