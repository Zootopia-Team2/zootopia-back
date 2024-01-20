package dev.team2.zoopoli.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team2.zoopoli.Models.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Long> {
}
