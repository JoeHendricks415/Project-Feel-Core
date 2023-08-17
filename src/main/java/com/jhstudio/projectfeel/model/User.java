package com.jhstudio.projectfeel.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    public User(){

    }
}
