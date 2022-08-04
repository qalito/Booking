package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Comfort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComfortRepository extends JpaRepository<Comfort, Integer> {
}
