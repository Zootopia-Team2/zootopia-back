// Specie.java
package dev.team2.zoopoli.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "specie")
public class Specie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecie;

    @Column(name = "specie")
    private String specie;

    @ManyToOne
    @JoinColumn(name = "id_family")
    private Family family;

    @OneToMany(mappedBy = "specie", cascade = CascadeType.ALL)
    private List<Animal> animals;

    public Specie() {
    }

    public Specie(Long idSpecie, String specie) {
        this.idSpecie = idSpecie;
        this.specie = specie;
    }

    public Long getIdSpecie() {
        return idSpecie;
    }

    public void setIdSpecie(Long idSpecie) {
        this.idSpecie = idSpecie;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setSpecie(this);
    }
}
