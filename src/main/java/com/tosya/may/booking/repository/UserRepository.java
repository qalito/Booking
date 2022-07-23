package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String username);
}
