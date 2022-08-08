package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Image;
import com.tosya.may.booking.exceptions.ImageNotFoundException;
import com.tosya.may.booking.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    public Image getById(int id) {
        return imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException(id));
    }
    public Image setImage(Image image){
        return imageRepository.save(image);
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
