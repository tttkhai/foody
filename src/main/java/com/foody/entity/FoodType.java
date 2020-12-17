package com.foody.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String food_type;

    public FoodType(){}

    public FoodType(int id, String food_type) {
        this.id = id;
        this.food_type = food_type;
    }
}
