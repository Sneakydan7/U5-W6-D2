package com.example.U4W6D2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "authors")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String profilePicture;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private Set<BlogPost> blogPosts = new LinkedHashSet<>();

    public Author(String name, String surname, String email, LocalDate dateOfBirth, String profilePicture) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
    }
}
