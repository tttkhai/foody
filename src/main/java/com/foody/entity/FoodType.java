package com.foody.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String food_type;

    public FoodType(int id, String food_type) {
        this.id = id;
        this.food_type = food_type;
    }
}
