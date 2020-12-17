package com.foody.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RestaurantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type_name;

    public RestaurantType(){}

    public RestaurantType(int id, String type_name) {
        this.id = id;
        this.type_name = type_name;
    }
}
