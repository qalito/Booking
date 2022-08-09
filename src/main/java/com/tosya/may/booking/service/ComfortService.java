package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Comfort;
import com.tosya.may.booking.repository.ComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComfortService {
    @Autowired
    private ComfortRepository comfortRepository;
    public List<Comfort> getComfort(){
        return comfortRepository.findAll();
    }
    public Comfort getComfortById(int id){return  comfortRepository.getById(id);}
    public List<Comfort> getAll(){return comfortRepository.findAll();};

    public void addComfort(Map<String, String> body) {
        Comfort comfort = new Comfort();
        comfort.setName(body.get("name"));
        comfort.setDescription(body.get("description"));
        comfortRepository.save(comfort);
    }
}
