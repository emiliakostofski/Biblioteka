package mk.finki.ukim.mk.labbiblioteka.service;


import mk.finki.ukim.mk.labbiblioteka.model.Author;
import mk.finki.ukim.mk.labbiblioteka.model.Books;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> save(Author author);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, Author author);

    void deleteById(Long id);


}
