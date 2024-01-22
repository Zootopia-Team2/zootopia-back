package dev.team2.zoopoli.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team2.zoopoli.Models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
