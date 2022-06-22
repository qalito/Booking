package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    private int id;
    private String login;
    private String name;
    private String password;
    private LocalDateTime regDate;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @OneToOne(mappedBy = "user")
    private Partner partner;
    @OneToMany(mappedBy = "user")
    private Set<Basket> baskets;
    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings;

}
