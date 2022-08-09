package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.City;
import com.tosya.may.booking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CountryService countryService;

    public List<City> getAll() {
        return (List<City>) cityRepository.findAll();
    }

    public List<City> getCityByCountry(int id) {
        return (List<City>) cityRepository.getCityByCountry(id);
    }

    public City getCityById(int id) {
        return cityRepository.getCitiesById(id);
    }

    public void addCity(Map<String, String> body) {
        City city = new City();
        city.setName(body.get("name"));
        city.setDescription(body.get("description"));
        city.setCountry(countryService.getById(Integer.parseInt(body.get("countryId"))));
        city.setImage(imageService.getByName("Нет фото"));
        cityRepository.save(city);
    }
}
