
package dev.team2.zoopoli.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;
    private String name;

    @JsonIgnore //Evita recursividad
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

}
