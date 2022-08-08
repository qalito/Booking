package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.BookingService;
import com.tosya.may.booking.service.CityService;
import com.tosya.may.booking.service.CountryService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @GetMapping("/admin")
    public String adminPage(Model model) {
        User user = userService.getAuthenticationUser();
        model.addAttribute("user", user);
        return "admin";
    }
    @GetMapping("/admin/users")
    public String allUsers(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }
    @GetMapping("/admin/country")
    public String allCountries(Model model) {
        model.addAttribute("listCountry", countryService.getAll());
        return "country";
    }
    @GetMapping("/admin/city")
    public String allCites(Model model) {
        model.addAttribute("listCity", cityService.getAll());
        return "city";
    }

    @GetMapping("/booking/{id}")
    public String getOrder(@PathVariable(value = "id") int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        return "";
    }
}