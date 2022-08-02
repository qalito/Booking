package com.tosya.may.booking.repository;

import com.tosya.may.booking.entity.Attempts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AttemptsRepository extends CrudRepository<Attempts, Integer> {
    Optional<Attempts> findAttemptsByUsername(String username);
}