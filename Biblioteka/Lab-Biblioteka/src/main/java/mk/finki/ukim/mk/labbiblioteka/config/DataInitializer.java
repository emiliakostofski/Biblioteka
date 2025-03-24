package mk.finki.ukim.mk.labbiblioteka.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.labbiblioteka.model.Author;
import mk.finki.ukim.mk.labbiblioteka.model.Books;
import mk.finki.ukim.mk.labbiblioteka.model.Country;
import mk.finki.ukim.mk.labbiblioteka.model.enumerations.Category;
import mk.finki.ukim.mk.labbiblioteka.repository.AuthorRepository;
import mk.finki.ukim.mk.labbiblioteka.repository.BooksRepository;
import mk.finki.ukim.mk.labbiblioteka.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BooksRepository booksRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {

        Country country = countryRepository.save(new Country("United Kingdom", "Europe"));
        Author author = authorRepository.save(new Author("Kolin", "Huver", country));
        booksRepository.save(new Books("9-ti Noemvri", Category.DRAMA,  author, 3));

        }
    }












//List<Country> countries = Arrays.asList(
//        new Country("United Kingdom", "Europe"),
//        new Country("United States", "North America"),
//        new Country("Germany", "Europe")
//);

//// Save countries
//        countries.forEach(countryRepository::save);
//
//
//
//Author author1 = new Author("Kolin", "Huver", countries.get(0));  // United Kingdom
//Author author2 = new Author("John", "Smith", countries.get(1));  // United States
//Author author3 = new Author("Hannah", "Müller", countries.get(2));  // Germany
//
//
//// Save authors
//        authorRepository.save(author1);
//        authorRepository.save(author2);
//        authorRepository.save(author3);
//
//author1 = authorRepository.findById(author1.getId()).orElseThrow(() -> new RuntimeException("Author not found"));
//author2 = authorRepository.findById(author2.getId()).orElseThrow(() -> new RuntimeException("Author not found"));
//author3 = authorRepository.findById(author3.getId()).orElseThrow(() -> new RuntimeException("Author not found"));
//
//        // Create books and associate them with authors
//        booksRepository.save(new Books("9-ti Noemvri", Category.DRAMA, author1, 3));
//        booksRepository.save(new Books("The Great Adventure", Category.DRAMA, author2, 5));
//        booksRepository.save(new Books("Der Wilde Westen", Category.THRILER, author3, 4));
//
//
//        }