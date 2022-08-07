package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Basket;
import com.tosya.may.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
    Basket findBasketByUser(User user);
}
