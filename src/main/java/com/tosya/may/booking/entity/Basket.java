package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Basket {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    private LocalDateTime checkoutTime;
    private LocalDate dateStart;
    private LocalDate dateTo;
    @ManyToMany
    @JoinTable(
            name = "basket_apartment",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id"))
    private Set<Apartment> basketApartment;
}
