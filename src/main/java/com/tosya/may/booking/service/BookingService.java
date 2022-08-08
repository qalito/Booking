package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.Basket;
import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;

    public List<Booking> returnAllBookingByUsername(String username) {
        return bookingRepository.findBookingsByUser(userService.getUser(username));
    }

    public List<Booking> returnAllBooking() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.getById(id);
    }

    public Booking addBooking(int basketId) {
        Basket basket = basketService.getById(basketId);
        Booking booking = new Booking();
        Set<Apartment> apartments = new HashSet<>();
        apartments.addAll(basket.getBasketApartment());
        booking.setBookingApartment(apartments);
        booking.setNumber(randomAlphabetic(6).toLowerCase());
        booking.setDateStart(basket.getDateStart());
        booking.setDateTo(basket.getDateTo());
        booking.setDateBooking(LocalDateTime.now());
        double sum = 0, count = Period.between(basket.getDateStart(), basket.getDateTo()).getDays()+1;
        sum = apartments
                .stream()
                .mapToDouble(apartment -> apartment.getPrice().doubleValue())
                .sum() * count;
        booking.setTotal(BigDecimal.valueOf(sum));
        booking.setUser(userService.getAuthenticationUser());
        System.out.println(booking);
        bookingRepository.save(booking);
        return booking;
    }
    public List<Booking> findBookingByUsername(String username){
        return bookingRepository.findBookingsByUser(userService.getUser(username));
    }
    public void deleteById(int id){
        bookingRepository.deleteById(id);
    }
}
