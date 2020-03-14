package com.foody.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String abbreviation;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "country_id")
    private Country country;

    public State(){}

    public State(int id, String name, String abbreviation, Country country) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.country = country;
    }

}
