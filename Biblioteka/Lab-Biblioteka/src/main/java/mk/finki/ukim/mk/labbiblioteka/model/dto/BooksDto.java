package mk.finki.ukim.mk.labbiblioteka.model.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.finki.ukim.mk.labbiblioteka.model.enumerations.Category;

@Data
public class BooksDto {

    private String name;

    private Category category;

    @NotNull
    private Long author;

    private Integer availableCopies;

    public BooksDto() {}

    public BooksDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}