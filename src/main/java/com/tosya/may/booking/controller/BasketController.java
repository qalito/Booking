package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.BasketService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BasketController {
    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;

    @PostMapping(value = "/confirm")
    public String addBookingBasket(ModelMap model, @RequestParam Map<String, String> body) {
        User user = userService.getAuthenticationUser();
        if (user != null)
            model.addAttribute("basket", basketService.addApartmentInBasket(body, user));
        else {
            return "redirect:/login";
        }
        return "/confirm";
    }

    @PostMapping(value = "/confirm/cancel/basket/{basketId}")
    public String canselBasket(ModelMap model, @PathVariable("basketId") int basket) {
        basketService.deleteById(basket);
        return "/";
    }
}
