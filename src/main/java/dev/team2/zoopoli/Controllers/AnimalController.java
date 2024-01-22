package dev.team2.zoopoli.Controllers;

import dev.team2.zoopoli.Models.Animal;
import dev.team2.zoopoli.Services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Optional<Animal> getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal newAnimal) {

        return animalService.saveAnimal(newAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        Optional<Animal> animalOptional = animalService.getAnimalById(id);
        if (!animalOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        updatedAnimal.setIdAnimal(id);
        animalService.saveAnimal(updatedAnimal);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        Optional<Animal> animalOptional = animalService.getAnimalById(id);
        if (!animalOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        animalService.deleteAnimalById(id);
        return ResponseEntity.ok().build();
    }

}
