package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepository extends CrudRepository<City,Integer> {
 List<City> getCityByCountry(int id);
 City getCitiesById(int id);
}
