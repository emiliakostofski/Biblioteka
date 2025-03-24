package mk.finki.ukim.mk.labbiblioteka.web;

import jakarta.validation.Valid;
import mk.finki.ukim.mk.labbiblioteka.model.Books;
import mk.finki.ukim.mk.labbiblioteka.model.dto.BooksDto;
import mk.finki.ukim.mk.labbiblioteka.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService bookService;

    public BooksController(BooksService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

//    @PostMapping
//    public Books save(@RequestBody BooksDto book) {
//        return bookService.save(book)
//                .orElseThrow(() -> new RuntimeException("Failed to create book"));
//    }

    @PostMapping
    public ResponseEntity<Books> save(@Valid @RequestBody BooksDto bookDto) {
        try {
            Books book = bookService.save(bookDto)
                    .orElseThrow(() -> new RuntimeException("Failed to create book"));
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Books> update(@PathVariable Long id, @RequestBody BooksDto book) {
        return bookService.update(id, book)
                .map(updatedBook -> ResponseEntity.ok(updatedBook))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/{id}/rent")
    public Books markBookAsRented(@PathVariable Long id) {
        return bookService.markAsRented(id)
                .orElseThrow(() -> new RuntimeException("Failed to mark book as rented or no available copies"));
    }
}

