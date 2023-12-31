package com.truecaller.repository;

import com.truecaller.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User,  Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
