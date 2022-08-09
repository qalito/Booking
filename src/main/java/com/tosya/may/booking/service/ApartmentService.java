package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.*;
import com.tosya.may.booking.repository.AddressRepository;
import com.tosya.may.booking.repository.ApartmentRepository;
import com.tosya.may.booking.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

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
                case "lang": {
                    break;
                }
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
        Apartment apartment = null;
        System.out.println(body);
        if (id == -1) {
            apartment = new Apartment();
            apartment.setPartner(userService.getAuthenticationUser().getPartner());
        } else {
            apartment = apartmentRepository.getById(Integer.valueOf(body.get("apartment")));
        }
        Address address = new Address();
        Set<Comfort> comfort = new HashSet<>();
        for (Map.Entry<String, String> entry : body.entrySet()) {
            System.out.println(entry.getKey());
            switch (entry.getKey()) {
                case "lang":

                case "apartment": {
                    break;
                }
                case "image":{
                    Map<String,String> map = new HashMap<>();
                    System.out.println(body.get("name"));
                    map.put("name", "Апартамент "+body.get("name").toString());
                    map.put("image",body.get("image"));
                    System.out.println(imageService.setImage(id,map));
                    apartment.setImage(imageService.setImage(id,map));
                    System.out.println(apartment.getImage());
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
                case "rating": {
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

    public List<Apartment> getApartmentByUsername(String username) {
        return apartmentRepository.findApartmentsByPartner(partnerRepository.findFirstByUser(userService.getUser(username)));
    }

}
