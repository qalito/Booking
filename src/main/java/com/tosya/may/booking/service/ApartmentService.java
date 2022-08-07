package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.City;
import com.tosya.may.booking.entity.Type;
import com.tosya.may.booking.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
