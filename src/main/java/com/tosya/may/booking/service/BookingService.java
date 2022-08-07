package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.Basket;
import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;
    public Basket addApartmentInBasket(Map<String, Apartment> body, User user){
        Basket basket = basketService.findUserBasket(user);
        basket.setUser(user);
        basket.setCheckoutTime(LocalDateTime.now().plusMinutes(10));
        Set<Apartment> apartment = basket.getBasketApartment();
        if (apartment == null) apartment= new HashSet<>();
         for (Map.Entry<String, Apartment> entry : body.entrySet()) {
            apartment.add(entry.getValue());
        }
        basket.setBasketApartment(apartment);
        //basket.setDateStart();
        //basket.setDateTo();
        System.out.println(apartment.toString());
        System.out.println(basket.toString());
        basket.setBasketApartment(apartment);
        basketService.save(basket);
        return basket;
    }

    public List<Booking> returnAllBookingByUsername(String username) {
        return  bookingRepository.findBookingsByUser(userService.getUser(username));
    }

    public List<Booking> returnAllOrders() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.getById(id);
    }
}
