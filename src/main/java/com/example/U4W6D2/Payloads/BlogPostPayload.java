package com.example.U4W6D2.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    @NotEmpty(message = "Enter a category")
    @Size(min = 1, max = 30, message = "Category characters must be between 1 and 30")
    private String category;
    @NotEmpty(message = "Enter a title")
    @Size(min = 1, max = 30, message = "Title characters must be between 1 and 30")
    private String title;
    private String cover;
    @NotEmpty(message = "Enter content section")
    @Size(min = 1, max = 500, message = "Content characters must be between 1 and 500")
    private String content;
    private int minutesOfReading;
    @NotEmpty(message = "Enter your id")
    private UUID authorId;
}
