package mk.finki.ukim.mk.labbiblioteka.repository;

import mk.finki.ukim.mk.labbiblioteka.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
