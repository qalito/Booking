package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.entity.City;
import com.tosya.may.booking.entity.Comfort;
import com.tosya.may.booking.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    List<Apartment> getApartmentByComfort(Set<Integer> comfort, City city, Type type, int count, LocalDate dateSt, LocalDate dateTo, String order);
    List<Apartment> getApartmentWithoutComfortSet(City city, Type type, int count, LocalDate dateSt, LocalDate dateTo, String order);
}
