package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
public class Apartment {
    @Id
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    private int capacity;
    private BigDecimal price;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;
    @OneToOne()
    @JoinColumn(name = "image_id")
    private Image image;
    @ManyToMany
    @JoinTable(
            name = "comfort_apartment",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "comfort_id"))
    private Set<Comfort> apartmentComfort;
    @ManyToMany(mappedBy = "basketApartment")
    Set<Basket> baskets;
    @ManyToMany(mappedBy = "bookingApartment")
    Set<Booking> bookings;
}
