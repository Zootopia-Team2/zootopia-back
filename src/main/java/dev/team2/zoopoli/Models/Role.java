package dev.team2.zoopoli.Models;

import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore //Evita recursividad
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

}
