package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Image;
import com.tosya.may.booking.service.CityService;
import com.tosya.may.booking.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    @GetMapping("/setImage")
    public void  getFile() throws IOException {
        InputStream in = getClass().getResourceAsStream("/image/img.png");
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[4];

        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        byte[] targetArray = buffer.toByteArray();
        Image img = new Image(2, "Тбилиси 2", "png", targetArray);
        imageService.setImage(img);
    }

}
