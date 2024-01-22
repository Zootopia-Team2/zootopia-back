// Family.java
package dev.team2.zoopoli.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFamily;

    @Column(name = "family")
    private String family;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
    private List<Specie> species;

    public Family() {
    }

    public Family(Long idFamily, String family) {
        this.idFamily = idFamily;
        this.family = family;
    }

    public Long getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Long idFamily) {
        this.idFamily = idFamily;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<Specie> getSpecies() {
        return species;
    }

    public void setSpecies(List<Specie> species) {
        this.species = species;
    }

    public void addSpecie(Specie specie) {
        species.add(specie);
        specie.setFamily(this);
    }
}
