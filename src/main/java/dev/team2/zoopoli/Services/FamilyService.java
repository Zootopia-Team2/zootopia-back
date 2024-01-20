// FamilyService.java
package dev.team2.zoopoli.Services;

import dev.team2.zoopoli.Models.Family;
import dev.team2.zoopoli.Repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    public Optional<Family> getFamilyById(Long id) {
        return familyRepository.findById(id);
    }

    public Family saveFamily(Family family) {
        return familyRepository.save(family);
    }

    public void deleteFamilyById(Long id) {
        familyRepository.deleteById(id);
    }
}
