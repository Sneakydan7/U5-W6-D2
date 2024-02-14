package com.example.U4W6D2.Repositories;

import com.example.U4W6D2.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorsDAO extends JpaRepository<Author, UUID> {
    boolean existsById(UUID id);

}
