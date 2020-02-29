package com.foody.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phone_code;

    public Country(int id, String name, String phone_code) {
        this.id = id;
        this.name = name;
        this.phone_code = phone_code;
    }
}
