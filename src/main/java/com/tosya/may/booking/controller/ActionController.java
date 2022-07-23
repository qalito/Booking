package com.tosya.may.booking.controller;

import com.tosya.may.booking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionController {
    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public String init(ModelMap model) {
        model.addAttribute("listCity", cityService.getAll());
        return "index";
    }


}
