package com.springboot.spring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private MoreData data;

 

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MoreData getData() {
        return data;
    }

    public void setData(MoreData data) {
        this.data = data;
    }


    public User() {
    }

    public User(String name, String email, MoreData data) {
        this.name = name;
        this.email = email;
        this.data = data;
    }
}
