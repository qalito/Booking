package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.City;
import com.tosya.may.booking.entity.Image;
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
        System.out.println(body.get("cityId") + "cityId");
        if (body.get("cityId") != null) {
            city = cityRepository.getCitiesById(Integer.parseInt(body.get("cityId")));
        }
        city.setName(body.get("name"));
        city.setDescription(body.get("description"));
        city.setCountry(countryService.getById(Integer.parseInt(body.get("countryId"))));
        if (body.get("cityId") == null) {
            Image image = new Image();
            Image noFoto = imageService.getByName("Нет фото");
            image.setData(noFoto.getData());
            image.setName("Город "+body.get("name"));
            image.setType(noFoto.getType());
            city.setImage(image);
        }
        cityRepository.save(city);
    }

    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }
}
