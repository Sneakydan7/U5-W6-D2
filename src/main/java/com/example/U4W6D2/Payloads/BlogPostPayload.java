package com.example.U4W6D2.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    private String category;
    private String title;
    private String cover;
    private String content;
    private int minutesOfReading;
    private UUID authorId;
}
