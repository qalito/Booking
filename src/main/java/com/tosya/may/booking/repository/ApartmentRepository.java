package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Apartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {

}
