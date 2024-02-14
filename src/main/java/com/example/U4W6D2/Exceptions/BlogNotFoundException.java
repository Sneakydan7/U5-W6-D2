package com.example.U4W6D2.Exceptions;

import java.util.UUID;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(Long postNumber) {
        super("Il post numero " + postNumber + " non è stato trovato");
    }
}
