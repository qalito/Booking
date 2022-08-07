package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.BookingService;
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
    @GetMapping("/admin")
    public String adminPage(Model model) {
        User user = userService.getAuthenticationUser();
        model.addAttribute("currentUser", user);
        return "/admin/adminPage";

    }
    @GetMapping("/admin/users")
    public String allUsers(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/allUsers";
    }

    @GetMapping("/users/{username}/page")
    public String userPage(Model model, @PathVariable("username") String username) {
        User user = userService.getUser(username);
        model.addAttribute("user", user);
        return "admin/userPage";
    }



    @GetMapping("/users/{username}/booking")
    public String getUserOrders(Model model, @PathVariable("username") String username) {
        List<Booking> booking = bookingService.returnAllBookingByUsername(username);
        model.addAttribute("booking", booking);
        return "user/bookingHistory";
    }


    @GetMapping("/allBooking")
    public String getAllOrders(Model model) {
        List<Booking> booking = bookingService.returnAllOrders();
        model.addAttribute("orders", booking);
        return "admin/allBooking";
    }

    @GetMapping("/booking/{id}")
    public String getOrder(@PathVariable(value = "id") int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        return "";
    }
}