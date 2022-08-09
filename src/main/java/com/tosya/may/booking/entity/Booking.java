package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Booking {
    @Id   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;
    private LocalDateTime dateBooking;
    private LocalDate dateStart;
    private LocalDate dateTo;
    /*Status ST - оформлено, AN - аннулировано, OK-подтверждено, CL-завершено*/
    private String status;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    private BigDecimal total;
    @ManyToMany
    @JoinTable(
            name = "booking_apartment",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id"))
    private Set<Apartment> bookingApartment;

}
