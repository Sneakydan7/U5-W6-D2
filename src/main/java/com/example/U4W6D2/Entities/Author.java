package com.example.U4W6D2.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Setter
@Getter
@ToString
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String profilePicture;

    public Author(int id, String name, String surname, String email, LocalDate dateOfBirth, String profilePicture) {
        Random random = new Random();
        this.id = random.nextInt(1, 500);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
    }
}
