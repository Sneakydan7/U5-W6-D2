package com.example.U4W6D2.Exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'utente con id " + id + " non è stato trovato");
    }
}