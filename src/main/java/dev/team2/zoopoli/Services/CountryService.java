// CountryService.java
package dev.team2.zoopoli.Services;

import dev.team2.zoopoli.Models.Country;
import dev.team2.zoopoli.Repositories.CountryRepository;
import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(@NonNull Long id) {
        return countryRepository.findById(id);
    }

    public Country saveCountry(@NonNull Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountryById(@NonNull Long id) {
        countryRepository.deleteById(id);
    }
}
