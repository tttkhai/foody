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

    private double lat;
    private double lng;

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



    // reviews
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "restaurant")
//    private List<Review> reviews;

}
