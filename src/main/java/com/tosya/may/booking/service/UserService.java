package com.tosya.may.booking.service;


import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String username) {
        return userRepository.findUserByUsername(username).get();
    }

    public User getAuthenticationUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return null;
        } else {
            return getUser((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
    }



    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
