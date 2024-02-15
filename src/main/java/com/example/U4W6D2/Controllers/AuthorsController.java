package com.example.U4W6D2.Controllers;

import com.example.U4W6D2.Entities.Author;
import com.example.U4W6D2.Services.AuthorsSRV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsSRV authorsSRV;

    @GetMapping
    public Page<Author> getAuthors(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String orderBy) {
        return this.authorsSRV.getAuthors(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable UUID id) {
        return this.authorsSRV.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {
        return this.authorsSRV.saveAuthor(newAuthor);

    }

    @PutMapping("/{id}")
    public Author modifyAuthorById(@PathVariable UUID id, @RequestBody Author updatedAuthor) {
        return this.authorsSRV.modifyAuthorById(updatedAuthor, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable UUID id) {
        this.authorsSRV.deleteAuthorById(id);
    }


    @PostMapping("/upload/{id}")
    public String uploadAvatarForAuthor(@RequestParam("image") MultipartFile image, @PathVariable UUID id) throws IOException {
        return this.authorsSRV.uploadImageForAuthor(image, id);
    }

}
