package com.foody.entity;

import lombok.Data;

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

    // type
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="Restaurant_RestaurantType",
            joinColumns= {@JoinColumn(name="restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")}
    )
    private List<Restaurant_type> types;

    // reviews
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "restaurant")
    private List<Review> reviews;

}
