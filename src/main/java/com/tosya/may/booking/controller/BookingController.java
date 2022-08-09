package com.tosya.may.booking.controller;


import com.tosya.may.booking.entity.Booking;
import com.tosya.may.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/create/booking/basket/{basketId}")
    public String confirmBasket(ModelMap model, @PathVariable("basketId") int basket){
        model.addAttribute("bookings", bookingService.addBooking(basket));
        return "redirect:/";
    }
    @GetMapping(value = "/users/{username}/booking")
    public String getUserBooing(ModelMap model, @PathVariable("username") String username){
        model.addAttribute("bookings",bookingService.findBookingByUsername(username));
        return "booking";
    }
    @GetMapping(value = "/change/booking/{id}/{status}")
    public String editBooking(ModelMap model, @PathVariable("id") int id,@PathVariable("status") String status){
        bookingService.changeStatus(status, id);
        return "redirect:/";
    }
    @GetMapping("/allBooking")
    public String getAllOrders(Model model) {
        List<Booking> booking = bookingService.returnAllBooking();
        model.addAttribute("bookings", booking);
        return "booking";
    }
    @GetMapping(value = "/booking/apartment/{id}")
    public String getBookingByApartment(ModelMap model, @PathVariable("id") int id){
        model.addAttribute("bookings", bookingService.findBookingByApartment(id));
        return "booking";
    }

}
