package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Image;
import com.tosya.may.booking.service.CityService;
import com.tosya.may.booking.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ActionController {
    @Autowired
    private CityService cityService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String init(ModelMap model) throws IOException {
       model.addAttribute("listCity", cityService.getAll());
        return "index";
    }


}
