package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
