//package mk.finki.ukim.mk.labbiblioteka.web;
//
//import mk.finki.ukim.mk.labbiblioteka.model.Author;
//import mk.finki.ukim.mk.labbiblioteka.service.AuthorService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/authors")
//public class AuthorController {
//    private final AuthorService authorService;
//
//    public AuthorController(AuthorService authorService) {
//        this.authorService = authorService;
//    }
//
//    @GetMapping
//    public List<Author> getAllAuthors() {
//        return authorService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Author getAuthorById(@PathVariable Long id) {
//        return authorService.findById(id);
//    }
//
//    @PostMapping
//    public Author createAuthor(@RequestBody Author author) {
//        return authorService.save(author);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAuthor(@PathVariable Long id) {
//        authorService.deleteById(id);
//    }
//}
