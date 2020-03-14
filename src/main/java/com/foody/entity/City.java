package com.foody.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int zip_code;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "state_id")
    private State state;

    public City(int id, String name, int zip_code, State state) {
        this.id = id;
        this.name = name;
        this.zip_code = zip_code;
        this.state = state;
    }
    public City(){}
}
