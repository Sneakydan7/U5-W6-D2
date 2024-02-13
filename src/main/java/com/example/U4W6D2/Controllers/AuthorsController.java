package com.example.U4W6D2.Controllers;

import com.example.U4W6D2.Entities.Author;
import com.example.U4W6D2.Services.AuthorsSRV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsSRV authorsSRV;

    @GetMapping
    public List<Author> getAllAuthors() {
        return this.authorsSRV.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return this.authorsSRV.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {
        return this.authorsSRV.saveAuthor(newAuthor);

    }

    @PutMapping("/{id}")
    public Author modifyAuthorById(@PathVariable int id, @RequestBody Author updatedAuthor) {
        return this.authorsSRV.modifyAuthorById(updatedAuthor, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable int id) {
        this.authorsSRV.deleteAuthorById(id);
    }

}
