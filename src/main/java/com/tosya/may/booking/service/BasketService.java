package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Basket;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

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
        //basketRepository.sa
    }
}