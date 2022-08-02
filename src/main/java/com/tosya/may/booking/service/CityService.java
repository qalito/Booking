package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.City;
import com.tosya.may.booking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAll() {
        return (List<City>) cityRepository.findAll();
    }

    List<City> getCityByCountry(int id) {
        return (List<City>) cityRepository.getCityByCountry(id);
    }
}
