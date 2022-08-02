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
    public void getImage(HttpServletResponse response, @PathVariable("id") final String id) throws IOException {
        System.out.println("getImages"+id);
        response.setContentType("image/jpeg");
        byte[] imageBytes = imageService.getById(Integer.parseInt(id)).getData();
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
    }
    @RequestMapping(value = "/images/{imageid}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody  byte[]  getImage(@PathVariable int imageid) throws IOException {
        byte[] image = imageService.getById(imageid).getData();
        return  image;

    }
    @GetMapping("/setImage")
    public void  getFile() throws IOException {
        System.out.println("getImages");
        InputStream in = getClass().getResourceAsStream("/image/img.png");
        System.out.println("Stream = " + in);
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
