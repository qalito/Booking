package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Country;
import com.tosya.may.booking.entity.Image;
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
        Country country = new Country();
        if (body.get("countyId") != null) {
            country = countryRepository.getById(Integer.parseInt(body.get("countyId")));
        }
        country.setName(body.get("name"));
        country.setDescription(body.get("description"));
        if (body.get("countyId") == null) {
            Image image = new Image();
            Image noFoto = imageService.getByName("Нет фото");
            image.setData(noFoto.getData());
            image.setName("Страна "+body.get("name"));
            image.setType(noFoto.getType());
            country.setImage(image);
        }
        countryRepository.save(country);
    }

    public Country getById(int id) {
        return countryRepository.getById(id);
    }

    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }
}
