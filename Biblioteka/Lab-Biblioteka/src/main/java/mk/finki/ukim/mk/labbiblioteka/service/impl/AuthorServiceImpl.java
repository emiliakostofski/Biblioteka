package mk.finki.ukim.mk.labbiblioteka.service.impl;

import mk.finki.ukim.mk.labbiblioteka.model.Author;
import mk.finki.ukim.mk.labbiblioteka.model.Country;
import mk.finki.ukim.mk.labbiblioteka.repository.AuthorRepository;
import mk.finki.ukim.mk.labbiblioteka.repository.CountryRepository;
import mk.finki.ukim.mk.labbiblioteka.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(Author author) {
        if (author.getCountry() != null && author.getCountry().getId() != null) {
            Optional<Country> countryOpt = countryRepository.findById(author.getCountry().getId());
            if (countryOpt.isPresent()) {
                author.setCountry(countryOpt.get());
                return Optional.of(authorRepository.save(author));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    if (author.getName() != null) {
                        existingAuthor.setName(author.getName());
                    }
                    if (author.getSurname() != null) {
                        existingAuthor.setSurname(author.getSurname());
                    }
                    if (author.getCountry() != null) {
                        existingAuthor.setCountry(author.getCountry());
                    }
                    return Optional.of(authorRepository.save(existingAuthor));
                })
                .orElse(Optional.empty());
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}


