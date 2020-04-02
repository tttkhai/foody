package com.foody.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Country country;

    public State(){}

    public State(int id, String name, String abbreviation, Country country) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.country = country;
    }

}
