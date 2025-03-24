package mk.finki.ukim.mk.labbiblioteka.repository;

import mk.finki.ukim.mk.labbiblioteka.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
