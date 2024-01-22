// CountryController.java
package dev.team2.zoopoli.Controllers;

import dev.team2.zoopoli.Models.Country;
import dev.team2.zoopoli.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country newCountry) {
        Country createdCountry = countryService.saveCountry(newCountry);
        return ResponseEntity.ok(createdCountry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country updatedCountry) {
        return countryService.getCountryById(id)
                .map(existingCountry -> {
                    updatedCountry.setIdCountry(id);
                    Country savedCountry = countryService.saveCountry(updatedCountry);
                    return ResponseEntity.ok(savedCountry);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(existingCountry -> {
                    countryService.deleteCountryById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
