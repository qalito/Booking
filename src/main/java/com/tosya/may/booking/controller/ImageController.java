package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Image;
import com.tosya.may.booking.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping("/getImages/{id}")
    public void getImage(HttpServletResponse response, @PathVariable("id") final int id) throws IOException {
        response.setContentType("image/jpeg");
        byte[] imageBytes = imageService.getById(id).getData();
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
    }

    @GetMapping("/admin/image")
    public String getImage(ModelMap model, @RequestParam Map<String, String> body) {
        model.addAttribute("imageList", imageService.findAll());
        return "image";
    }

    @PostMapping("/set/image/{id}")
    public String setImage(ModelMap model, @PathVariable("id") int id, @RequestParam Map<String, String> body) {
        imageService.setImage(id,body);
        imageService.save( imageService.setImage(id,body));
        model.addAttribute("imageList", imageService.findAll());
        return "image";
    }


}
