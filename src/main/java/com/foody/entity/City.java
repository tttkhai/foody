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
}
