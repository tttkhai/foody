package com.foody.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cleanliness;
    private int customer_service;
    private int deliver;
    private int taste;

    private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    public Review(){}
}
