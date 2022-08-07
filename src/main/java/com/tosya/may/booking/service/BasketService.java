package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.Basket;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ApartmentService apartmentService;
    public Basket addApartmentInBasket(Map<String, String> body, User user) {
        Basket basket = findUserBasket(user);
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
        basket.setBasketApartment(apartments);
        save(basket);
        return basket;
    }

    public Basket findUserBasket(User user) {
        Basket basket = basketRepository.findBasketByUser(user);
        System.out.println(basket);
        if (basket != null) {
            return basket;
        } else {
            return new Basket();
        }
    }
    public Basket getById(int id){
        return basketRepository.getById(id);
    }

    public void save(Basket basket) {
        basketRepository.save(basket);
    }
    public void deleteByCheckoutTimeBefore(){
        basketRepository.deleteByCheckoutTimeBefore(LocalDateTime.now());
    }
    public void deleteById(int basket){
        basketRepository.deleteById(basket);
    }
}