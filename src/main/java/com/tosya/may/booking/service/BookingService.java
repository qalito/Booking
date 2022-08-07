package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.Basket;
import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.entity.User;
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
    private ApartmentService apartmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;

    public Basket addApartmentInBasket(Map<String, String> body, User user) {
        Basket basket = basketService.findUserBasket(user);
        basket.setUser(user);
        basket.setCheckoutTime(LocalDateTime.now().plusMinutes(10));
        Set<Apartment> apartments = basket.getBasketApartment();
        if (apartments == null) apartments = new HashSet<>();
        for (Map.Entry<String, String> entry : body.entrySet()) {
            Apartment apartment = apartmentService.getById(Integer.parseInt(entry.getValue()));
            if (apartment != null) apartments.add(apartment);
        }
        basket.setBasketApartment(apartments);
        //basket.setDateStart();
        //basket.setDateTo();
        System.out.println(apartments.toString());
        System.out.println(basket.toString());
        basket.setBasketApartment(apartments);
        basketService.save(basket);
        return basket;
    }

    public List<Booking> returnAllBookingByUsername(String username) {
        return bookingRepository.findBookingsByUser(userService.getUser(username));
    }

    public List<Booking> returnAllOrders() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.getById(id);
    }

    public Booking addBooking(int basketId) {
        Basket basket = basketService.getById(basketId);
        Booking booking = new Booking();
        Set<Apartment> apartments = basket.getBasketApartment();
        booking.setBookingApartment(apartments);
        booking.setNumber(randomAlphabetic(6).toLowerCase());
        booking.setDateStart(basket.getDateStart());
        booking.setDateTo(basket.getDateTo());
        booking.setDateBooking(LocalDateTime.now());
        double sum = 0, count = Period.between(basket.getDateStart(), basket.getDateTo()).getDays();
        sum = apartments
                .stream()
                .mapToDouble(apartment -> apartment.getPrice().doubleValue())
                .sum() * count;
        booking.setTotal(BigDecimal.valueOf(sum));
        booking.setUser(userService.getAuthenticationUser());
        bookingRepository.save(booking);
        return booking;
    }
}
