package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Type;
import com.tosya.may.booking.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    public List<Type> getFilter(){
        return typeRepository.findAll();
    }
    public Type getTypeById(int id){
        return typeRepository.getById(id);
    }
}
