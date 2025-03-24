package mk.finki.ukim.mk.labbiblioteka.service.impl;

import mk.finki.ukim.mk.labbiblioteka.model.Country;
import mk.finki.ukim.mk.labbiblioteka.repository.CountryRepository;
import mk.finki.ukim.mk.labbiblioteka.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id)
                .map(existingCountry -> {
                    existingCountry.setName(country.getName());
                    existingCountry.setContinent(country.getContinent());
                    return countryRepository.save(existingCountry);
                });
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
