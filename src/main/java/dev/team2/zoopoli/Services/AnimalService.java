package dev.team2.zoopoli.Services;

import dev.team2.zoopoli.Models.Animal;
import dev.team2.zoopoli.Repositories.AnimalRepository;
import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(@NonNull Long id) {
        return animalRepository.findById(id);
    }

    public Animal saveAnimal(@NonNull Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimalById(@NonNull Long id) {
        animalRepository.deleteById(id);
    }

}
