package com.example.U4W6D2.Services;

import com.example.U4W6D2.Entities.Author;
import com.example.U4W6D2.Entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AuthorsSRV {
    public List<Author> authors = new ArrayList<>();

    public List<Author> getAllAuthors() {
        return this.authors;
    }

    public Author getAuthorById(int id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
            }
        }
        return found;
    }

    public Author saveAuthor(Author newAuthor) {
        this.authors.add(newAuthor);
        return newAuthor;
    }

    public Author modifyAuthorById(Author updatedAuthor, int id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setName(updatedAuthor.getName());
                found.setSurname(updatedAuthor.getSurname());
                found.setEmail(updatedAuthor.getEmail());
                found.setProfilePicture(updatedAuthor.getProfilePicture());
                found.setDateOfBirth(updatedAuthor.getDateOfBirth());
            }
        }
        return found;
    }

    public void deleteAuthorById(int id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

}
