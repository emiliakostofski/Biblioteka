package mk.finki.ukim.mk.labbiblioteka.repository;

import mk.finki.ukim.mk.labbiblioteka.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
