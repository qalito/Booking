package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.City;
import com.tosya.may.booking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public Iterable<City> getAll() {
        return cityRepository.findAll();
    }
}
