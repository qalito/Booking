package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Type;
import com.tosya.may.booking.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getFilter() {
        return typeRepository.findAll();
    }

    public Type getTypeById(int id) {
        return typeRepository.getById(id);
    }

    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    public void addType(Map<String, String> body) {
        Type type = new Type();
        type.setName(body.get("name"));
        type.setDescription(body.get("description"));
        typeRepository.save(type);
    }

    public void deleteById(int id) {
        typeRepository.deleteById(id);
    }
}
