package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Country;
import com.tosya.may.booking.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll() {
        return (List<Country>) countryRepository.findAll();
    }
}
