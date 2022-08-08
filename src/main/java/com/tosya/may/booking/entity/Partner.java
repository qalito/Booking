package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Partner {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
    private double raiting;
    @OneToMany(mappedBy="partner")
    private Set<Apartment> apartments;
}
