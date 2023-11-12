package com.example.wsServer.wsDemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User
{
    @Id
    private String id;
    private int role;

    public User(String id, int role)
    {
        this.id = id;
        this.role = role;
    }

    public User() { }

    public String getId() {
        return id;
    }

    public int getRole() {return role;}

    public void setId(String id) {
        this.id = id;
    }

}

