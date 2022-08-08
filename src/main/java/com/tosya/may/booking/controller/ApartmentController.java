package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ApartmentController {
    @Autowired
    private CityService cityService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ComfortService comfortService;

    @GetMapping(value = "/searchresults")
    public String getAllByFilterAndComfort(ModelMap model, @RequestParam Map<String, String> body) {
        model.addAllAttributes(body);
        model.addAttribute("listFilter", typeService.getFilter());
        model.addAttribute("listComfort", comfortService.getComfort());
        model.addAttribute("listCity", cityService.getAll());
        List<Apartment> listApartments = apartmentService.getAllBy(body);
        model.addAttribute("listApartments", listApartments);
        model.addAttribute("countApartments", listApartments.size());
        return "searchresults";
    }

}
