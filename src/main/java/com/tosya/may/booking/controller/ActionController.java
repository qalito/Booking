package com.tosya.may.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionController {

    @GetMapping("/")
    public String init() {
        return "index";
    }

}
