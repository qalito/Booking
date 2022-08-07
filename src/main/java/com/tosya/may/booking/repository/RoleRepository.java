package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findFirstRoleByName(String name);
}
