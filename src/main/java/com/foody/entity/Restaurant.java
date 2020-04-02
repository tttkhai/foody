package com.foody.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // Restaurant type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_types_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RestaurantType restaurant_types;

    // food type
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="Restaurant_FoodType",
            joinColumns= {@JoinColumn(name="restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "food_id")}
    )
    private List<FoodType> food_types;

    public Restaurant(){}

    public Restaurant(int id, String name, String email, String address, String phoneNumber, RestaurantType restaurant_types, List<FoodType> food_types) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.restaurant_types = restaurant_types;
        this.food_types = food_types;
    }

    // reviews
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "restaurant")
//    private List<Review> reviews;

}
