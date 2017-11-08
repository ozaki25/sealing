package com.example.sealing.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.sealing.type.StatusType;

@Entity
public class DailyRequest {
    @Id
    @GeneratedValue
    private Long id;
    private Integer statusType = 0;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dailyRequest")
    private List<Request> requests = new ArrayList<Request>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getStatusType() {
        return statusType;
    }
    public void setStatusType(Integer statusType) {
        this.statusType = statusType;
    }
    public List<Request> getRequests() {
        return requests;
    }
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public String getStatusTypeName() {
        return StatusType.getStatusTypeByValue(this.statusType).getName();
    }

    @Override
    public String toString() {
        return "DailyRequest [id=" + id + ", statusType=" + statusType + "]";
    }
}