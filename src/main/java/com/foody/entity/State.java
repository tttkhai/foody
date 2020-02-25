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
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

}
