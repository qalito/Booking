package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private ComfortService comfortService;
    @Autowired
    private TypeService typeService;
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
        model.addAttribute("listCountry", countryService.getAll());
        model.addAttribute("listCity", cityService.getAll());
        return "city";
    }
    @GetMapping("/admin/comfort")
    public String allComfort(Model model) {
        model.addAttribute("comfort", comfortService.getAll());
        return "comfort";
    }
    @GetMapping("/admin/type")
    public String allType(Model model) {
        model.addAttribute("type", typeService.getAll());
        return "type";
    }

    @GetMapping("/booking/{id}")
    public String getOrder(@PathVariable(value = "id") int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        return "booking";
    }
    @PostMapping("admin/country/add")
    public String addCountry(@RequestParam Map<String, String> body){
        countryService.addCountry(body);
        return "redirect:/admin/country";
    }
    @PostMapping("admin/city/add")
    public String addCity(@RequestParam Map<String, String> body){
        cityService.addCity(body);
        return "redirect:/admin/city";
    }
    @PostMapping("/admin/comfort/add")
    public String addComfort(@RequestParam Map<String, String> body) {
        comfortService.addComfort(body);
        return "redirect:/admin/comfort";
    }
    @PostMapping("/admin/type/add")
    public String addType(@RequestParam Map<String, String> body) {
       typeService.addType(body);
        return "redirect:/admin/type";
    }
}