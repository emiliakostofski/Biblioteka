package mk.finki.ukim.mk.labbiblioteka.service.impl;

import mk.finki.ukim.mk.labbiblioteka.model.Author;
import mk.finki.ukim.mk.labbiblioteka.model.Books;
import mk.finki.ukim.mk.labbiblioteka.model.dto.BooksDto;
import mk.finki.ukim.mk.labbiblioteka.repository.AuthorRepository;
import mk.finki.ukim.mk.labbiblioteka.repository.BooksRepository;
import mk.finki.ukim.mk.labbiblioteka.service.AuthorService;
import mk.finki.ukim.mk.labbiblioteka.service.BooksService;
import mk.finki.ukim.mk.labbiblioteka.service.CountryService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;


@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorService authorService;

    public BooksServiceImpl(BooksRepository booksRepository, AuthorService authorService) {
        this.booksRepository = booksRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Books> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Books> save(BooksDto bookDto) {
        if (bookDto.getAuthor() != null) {
            Optional<Author> author = authorService.findById(bookDto.getAuthor());
            if (author.isPresent()) {
                Books book = new Books(bookDto.getName(), bookDto.getCategory(), author.get(), bookDto.getAvailableCopies());
                return Optional.of(booksRepository.save(book));
            } else {
                throw new RuntimeException("Author not found with ID: " + bookDto.getAuthor());
            }
        }
        throw new RuntimeException("Author ID is null.");
    }

    @Override
    public Optional<Books> findById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Optional<Books> update(Long id, BooksDto books) {
        return booksRepository.findById(id)
                .map(existingBook -> {
                    if (books.getName() != null) {
                        existingBook.setName(books.getName());
                    }
                    if (books.getAuthor() != null && authorService.findById(books.getAuthor()).isPresent()) {
                        existingBook.setAuthor(authorService.findById(books.getAuthor()).get());
                    }
                    if (books.getAvailableCopies() != null) {
                        if (books.getAvailableCopies() < 0) {
                            throw new RuntimeException("Available copies cannot be negative.");
                        }
                        existingBook.setAvailableCopies(books.getAvailableCopies());
                    }
                    return booksRepository.save(existingBook);
                });
    }


    @Override
    public Optional<Books> markAsRented(Long id) {
        return booksRepository.findById(id)
                .map(book -> {
                    if (book.getAvailableCopies() > 0) {
                        book.setAvailableCopies(book.getAvailableCopies() - 1);
                        return Optional.of(booksRepository.save(book));
                    } else {
                        throw new RuntimeException("No available copies to rent.");
                    }
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }
}


