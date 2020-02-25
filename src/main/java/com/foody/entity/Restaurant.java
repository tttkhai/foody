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

    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Restaurant_type> types;

    @OneToMany(mappedBy = "reviews")
    private List<Review> reviews;

}
