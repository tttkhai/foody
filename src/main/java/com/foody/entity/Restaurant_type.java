package com.foody.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Restaurant_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type_name;

    @ManyToMany(mappedBy = "types")
    private List<Restaurant> restaurants;

    public Restaurant_type(int id, String type_name, List<Restaurant> restaurants) {
        this.id = id;
        this.type_name = type_name;
        this.restaurants = restaurants;
    }
}
