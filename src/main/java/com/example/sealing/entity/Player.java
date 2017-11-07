package com.example.sealing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.sealing.type.RoleType;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String userId;
    private String password;
    private Integer roleType;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getRoleType() {
        return roleType;
    }
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
    public String getRoleTypeLabel() {
        return RoleType.getRoleTypeByValue(this.roleType).getLabel();
    }
}