package dev.team2.zoopoli.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team2.zoopoli.Models.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
}
