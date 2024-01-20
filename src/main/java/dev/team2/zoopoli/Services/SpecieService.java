// SpecieService.java
package dev.team2.zoopoli.Services;

import dev.team2.zoopoli.Models.Specie;
import dev.team2.zoopoli.Repositories.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecieService {

    @Autowired
    private SpecieRepository specieRepository;

    public List<Specie> getAllSpecies() {
        return specieRepository.findAll();
    }

    public Optional<Specie> getSpecieById(Long id) {
        return specieRepository.findById(id);
    }

    public Specie saveSpecie(Specie specie) {
        return specieRepository.save(specie);
    }

    public void deleteSpecieById(Long id) {
        specieRepository.deleteById(id);
    }
}
