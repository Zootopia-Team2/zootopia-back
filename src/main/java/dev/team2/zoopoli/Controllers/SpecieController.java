// SpecieController.java
package dev.team2.zoopoli.Controllers;

import dev.team2.zoopoli.Models.Specie;
import dev.team2.zoopoli.Services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/species")
public class SpecieController {

    @Autowired
    private SpecieService specieService;

    @GetMapping
    public List<Specie> getAllSpecies() {
        return specieService.getAllSpecies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specie> getSpecieById(@PathVariable Long id) {
        return specieService.getSpecieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Specie> createSpecie(@RequestBody Specie newSpecie) {
        Specie createdSpecie = specieService.saveSpecie(newSpecie);
        return ResponseEntity.ok(createdSpecie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specie> updateSpecie(@PathVariable Long id, @RequestBody Specie updatedSpecie) {
        return specieService.getSpecieById(id)
                .map(existingSpecie -> {
                    updatedSpecie.setIdSpecie(id);
                    Specie savedSpecie = specieService.saveSpecie(updatedSpecie);
                    return ResponseEntity.ok(savedSpecie);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecie(@PathVariable Long id) {
        return specieService.getSpecieById(id)
                .map(existingSpecie -> {
                    specieService.deleteSpecieById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
