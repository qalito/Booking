package com.tosya.may.booking.controller;


import com.tosya.may.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/create/booking/basket/{basketId}")
    public String confirmBasket(ModelMap model, @PathVariable("basketId") int basket){
        bookingService.addBooking(basket);
        return "/";
    }
}
