package mk.finki.ukim.mk.labbiblioteka.service;

import mk.finki.ukim.mk.labbiblioteka.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {


    List<Country> findAll();

    Country save(Country country);

    Country findById(Long id);

    Optional<Country> update(Long id, Country country);

    void deleteById(Long id);

}
