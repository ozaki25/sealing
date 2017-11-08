package com.example.sealing.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.example.sealing.type.StatusType;

@Entity
public class Request {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer statusType = 0;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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
    public Integer getStatusType() {
        return statusType;
    }
    public void setStatusType(Integer statusType) {
        this.statusType = statusType;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getStatusTypeName() {
        return StatusType.getStatusTypeByValue(this.statusType).getName();
    }

    @PrePersist
    public void prePersist() {
        Timestamp timestamp = new Timestamp((new Date()).getTime());
        this.createdAt = timestamp;
        this.updatedAt = timestamp;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Timestamp((new Date()).getTime());
    }

    @Override
    public String toString() {
        return "Request [id=" + id + ", name=" + name + ", statusType=" + statusType + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

}