package com.example.U4W6D2.Services;

import com.example.U4W6D2.Entities.Author;
import com.example.U4W6D2.Entities.BlogPost;
import com.example.U4W6D2.Exceptions.NotFoundException;
import com.example.U4W6D2.Repositories.AuthorsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorsSRV {
    @Autowired
    private AuthorsDAO authorsDAO;

    public Page<Author> getAuthors(int pageNum, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(orderBy));
        return authorsDAO.findAll(pageable);
    }

    public Author getAuthorById(UUID id) {
        return authorsDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author saveAuthor(Author newAuthor) {
        return authorsDAO.save(newAuthor);
    }

    public Author modifyAuthorById(Author updatedAuthor, UUID id) {
        Author found = this.getAuthorById(id);
        found.setName(updatedAuthor.getName());
        found.setSurname(updatedAuthor.getSurname());
        found.setEmail(updatedAuthor.getEmail());
        found.setProfilePicture(updatedAuthor.getProfilePicture());
        found.setDateOfBirth(updatedAuthor.getDateOfBirth());
        return authorsDAO.save(found);
    }


    public void deleteAuthorById(UUID id) {
        Author found = this.getAuthorById(id);
        authorsDAO.delete(found);
    }

}
