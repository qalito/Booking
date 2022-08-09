package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.entity.Partner;
import com.tosya.may.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingsByUser(User user);
    List<Booking> findBookingsByBookingApartment(Apartment apartment);
}
