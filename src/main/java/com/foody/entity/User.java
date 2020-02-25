package com.foody.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "review_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;


}
