package com.tosya.may.booking.controller;

import com.tosya.may.booking.service.ApartmentService;
import com.tosya.may.booking.service.ComfortService;
import com.tosya.may.booking.service.TypeService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ComfortService comfortService;
    @GetMapping("/searchresults")
    public String getAll(ModelMap model) {
        model.addAttribute("listApartments", apartmentService.getAll());
        model.addAttribute("listFilter", typeService.getFilter());
        model.addAttribute("listComfort", comfortService.getComfort());
        return "searchresults";
    }

}
