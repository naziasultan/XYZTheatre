package com.theatre.xyz.repository;

import com.theatre.xyz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define custom queries
    Optional<User> findByUsername(String username);
}
