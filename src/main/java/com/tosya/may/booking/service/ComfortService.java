package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Comfort;
import com.tosya.may.booking.repository.ComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComfortService {
    @Autowired
    private ComfortRepository comfortRepository;
    public List<Comfort> getComfort(){
        return comfortRepository.findAll();
    }
}
