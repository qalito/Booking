package com.tosya.may.booking.controller;


import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.ApartmentService;
import com.tosya.may.booking.service.BookingService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/confirm")
    public String addBookingBasket(ModelMap model, @RequestParam Map<String, Apartment> body) {
        User user = userService.getAuthenticationUser();
        if (user != null)
            model.addAttribute("listApartments", bookingService.addApartmentInBasket(body, user));
        else {
            return "redirect:/login";
        }
        return "/confirm";
    }
}
