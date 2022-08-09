package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Image;
import com.tosya.may.booking.exceptions.ImageNotFoundException;
import com.tosya.may.booking.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image getById(int id) {
        return imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException(id));
    }

    public Image setImage(int id, Map<String, String> body) {
        Image img = new Image();
        try {
            String file = "C:\\Users\\tosya\\Desktop\\фото для проекта\\" + body.get("image");
            InputStream in = new FileInputStream(file);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[4];

            while ((nRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] targetArray = buffer.toByteArray();
            if (id != -1) {
                img = new Image(id, body.get("name"), "jpg", targetArray);
            } else {
                img = new Image(body.get("name"), "jpg", targetArray);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageRepository.save(img);
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public Image getByName(String name) {
        return imageRepository.findFirstByName(name);
    }
}
