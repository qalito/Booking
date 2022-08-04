package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Role;
import com.tosya.may.booking.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role getRoleByName(String name){
        return  roleRepository.findFirstRoleByName(name);
    }
}
