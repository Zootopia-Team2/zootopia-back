// FamilyController.java
package dev.team2.zoopoli.Controllers;

import dev.team2.zoopoli.Models.Family;
import dev.team2.zoopoli.Services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/families")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping
    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Family> getFamilyById(@PathVariable Long id) {
        return familyService.getFamilyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Family> createFamily(@RequestBody Family newFamily) {
        Family createdFamily = familyService.saveFamily(newFamily);
        return ResponseEntity.ok(createdFamily);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Family> updateFamily(@PathVariable Long id, @RequestBody Family updatedFamily) {
        return familyService.getFamilyById(id)
                .map(existingFamily -> {
                    updatedFamily.setIdFamily(id);
                    Family savedFamily = familyService.saveFamily(updatedFamily);
                    return ResponseEntity.ok(savedFamily);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamily(@PathVariable Long id) {
        return familyService.getFamilyById(id)
                .map(existingFamily -> {
                    familyService.deleteFamilyById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
