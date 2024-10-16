package com.springboot.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class MoreData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String address;
    private String manager;

    @OneToOne(mappedBy = "data") //establishing the bidirectional relation 
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MoreData() {
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getManager() {
        return manager;
    }

    public MoreData(String address, String manager) {
        this.address = address;
        this.manager = manager;
    }
}
