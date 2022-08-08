package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.*;
import com.tosya.may.booking.repository.AddressRepository;
import com.tosya.may.booking.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ComfortService comfortService;

    public Apartment getById(int id) {
        return apartmentRepository.getById(id);
    }

    public List<Apartment> getAll() {
        return (List<Apartment>) apartmentRepository.findAll();
    }

    public List<Apartment> getAllBy(Map<String, String> body) {
        Set<Integer> comfort = new HashSet<Integer>();
        Type type = null;
        LocalDate dateSt = null, dateTo = null;
        City city = null;
        int count = 0;
        String order = "rating asc";
        System.out.println(body.entrySet());
        for (Map.Entry<String, String> entry : body.entrySet()) {
            System.out.println(entry.getKey());
            switch (entry.getKey()) {
                case "dateStart": {
                    dateSt = LocalDate.parse(entry.getValue());
                    break;
                }
                case "dateTo": {
                    dateTo = LocalDate.parse(entry.getValue());
                    break;
                }
                case "filter": {
                    type = typeService.getTypeById(Integer.parseInt(entry.getValue()));
                    break;
                }
                case "selectedCityId": {
                    city = cityService.getCityById(Integer.parseInt(entry.getValue()));
                    break;
                }
                case "count": {
                    count = Integer.parseInt(entry.getValue());
                    break;
                }
                case "order": {
                    order = entry.getValue();
                    break;
                }
                default: {
                    comfort.add(Integer.parseInt(entry.getValue()));
                    break;
                }
            }
        }
        return comfort.size() > 0 ?
                apartmentRepository.getApartmentByComfort(comfort, city, type, count, dateSt, dateTo, order) :
                apartmentRepository.getApartmentWithoutComfortSet(city, type, count, dateSt, dateTo, order);
    }

    public void editApartmentByMap(Map<String, String> body, int id) {
        System.out.println(body);
        Apartment apartment = apartmentRepository.getById(Integer.valueOf(body.get("apartment")));
        Address address = new Address();
        Set<Comfort> comfort = new HashSet<>();
        for (Map.Entry<String, String> entry : body.entrySet()) {
            System.out.println(entry.getKey());
            switch (entry.getKey()) {
                case "apartment": {
                    break;
                }
                case "name": {
                    apartment.setName(entry.getValue());
                    break;
                }
                case "selectedCityId": {
                    address.setCity(cityService.getCityById(Integer.parseInt(entry.getValue())));
                    address.setCountry(cityService.getCityById(Integer.parseInt(entry.getValue())).getCountry());
                    break;
                }
                case "address": {
                    address.setValue(entry.getValue());
                    break;
                }
                case "capacity": {
                    apartment.setCapacity(Integer.parseInt(entry.getValue()));
                    break;
                }
                case "price": {
                    apartment.setPrice(new BigDecimal(entry.getValue()));
                    break;
                }
                case "raiting": {
                    apartment.setRating(Double.parseDouble(entry.getValue()));
                    break;
                }
                case "filter": {
                    apartment.setType(typeService.getTypeById(Integer.parseInt((entry.getValue()))));
                    break;
                }
                default: {
                    comfort.add(comfortService.getComfortById(Integer.parseInt(entry.getValue())));
                    break;
                }
            }
        }
        apartment.setAddress(address);
        apartment.setApartmentComfort(comfort);
        apartmentRepository.save(apartment);

    }
}
