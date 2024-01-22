package dev.team2.zoopoli.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team2.zoopoli.Models.User;

public interface UserRepository extends JpaRepository <User, Long> {
    public Optional<User> findByUsername(String username);
    
}
