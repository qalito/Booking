package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Apartment;
import com.tosya.may.booking.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;
    public List<Apartment> getAll(){
        return (List<Apartment>) apartmentRepository.findAll();
    }
}
