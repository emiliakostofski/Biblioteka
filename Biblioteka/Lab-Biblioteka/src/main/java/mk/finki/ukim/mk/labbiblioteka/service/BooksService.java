package mk.finki.ukim.mk.labbiblioteka.service;


import mk.finki.ukim.mk.labbiblioteka.model.Author;
import mk.finki.ukim.mk.labbiblioteka.model.Books;
import mk.finki.ukim.mk.labbiblioteka.model.dto.BooksDto;

import java.util.List;
import java.util.Optional;

public interface BooksService {


    List<Books> findAll();

    Optional<Books> save(BooksDto books);

    Optional<Books> findById(Long id);

    Optional<Books> update(Long id, BooksDto books);

    Optional<Books> markAsRented(Long id);

    void deleteById(Long id);
}
