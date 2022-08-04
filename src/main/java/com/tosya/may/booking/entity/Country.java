package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Country {
    @Id
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "country")
    private Set<Address> addresses;
    @OneToMany(mappedBy = "country")
    private List<City> cities;
    @ManyToOne()
    @JoinColumn(name = "image_id")
    private Image image;
}
