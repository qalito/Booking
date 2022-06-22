package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class City {
    @Id
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "city")
    private Set<Address> addresses;
}
