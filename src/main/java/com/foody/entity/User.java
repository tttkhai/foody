package com.foody.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.*;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn(name="role_id")
    private Role role;

    public User(){}

    public User(int id, String username, String password, String firstName, String lastName, String email, String address, String phoneNumber, Role role){
        this.id=id;
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.role=role;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> role = new ArrayList<>();
        role.add(new SimpleGrantedAuthority(this.role.getName()));
        return role;
    }
}
