package com.foody.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 1, message = "rate can't be less than 1 or more than 5")
    @Max(value = 5)
    private int cleanliness;

    @Min(value = 1, message = "rate can't be less than 1 or more than 5")
    @Max(value = 5)
    private int customer_service;

    @Min(value = 1, message = "rate can't be less than 1 or more than 5")
    @Max(value = 5)
    private int deliver;

    @Min(value = 1, message = "rate can't be less than 1 or more than 5")
    @Max(value = 5)
    private int taste;

    private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public Review(){}
}
