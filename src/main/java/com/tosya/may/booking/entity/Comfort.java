package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Comfort {
    @Id
    private int id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "apartmentComfort")
    Set<Apartment> apartments;
}
