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

    @GetMapping("/setImage")
    public void getFile() throws IOException {
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

    @GetMapping("/admin/image")
    public String getImage(ModelMap model, @RequestParam Map<String, String> body) {
        model.addAttribute("imageList", imageService.findAll());
        return "image";
    }

    @PostMapping("/set/image/{id}")
    public String setImage(ModelMap model, @PathVariable("id") int id, @RequestParam Map<String, String> body) {
        try {
            String file="C:\\Users\\tosya\\Desktop\\фото для проекта\\"+body.get("image");
            InputStream in = new FileInputStream(file);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[4];

            while ((nRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] targetArray = buffer.toByteArray();
            Image img = new Image(id, body.get("name"), "jpg", targetArray);
            System.out.println("targetArray");
            imageService.setImage(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("imageList", imageService.findAll());
        return "image";
    }


}
