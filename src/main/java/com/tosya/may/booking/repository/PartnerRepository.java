package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Partner;
import com.tosya.may.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner findFirstByUser(User user);

}
