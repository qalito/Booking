package com.tosya.may.booking.controller;

import com.tosya.may.booking.service.ApartmentService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;
    @GetMapping("/searchresults")
    public String getAll(ModelMap model) {
        model.addAttribute("apartments", apartmentService.getAll());
        return "searchresults";
    }

}
