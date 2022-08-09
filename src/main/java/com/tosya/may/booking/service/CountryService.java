package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Country;
import com.tosya.may.booking.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ImageService imageService;

    public List<Country> getAll() {
        return (List<Country>) countryRepository.findAll();
    }

    public void addCountry(Map<String, String> body) {
        Country country= new Country();
        country.setName(body.get("name"));
        country.setDescription(body.get("description"));
        country.setImage(imageService.getByName("Нет фото"));
        countryRepository.save(country);
    }
    public Country getById(int id){
        return countryRepository.getById(id);
    }
}
