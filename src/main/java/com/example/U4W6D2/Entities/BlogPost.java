package com.example.U4W6D2.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.Random;

@Setter
@Getter
@ToString
public class BlogPost {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int minutesOfReading;

    public BlogPost(int id, String category, String title, String cover, String content, int minutesOfReading) {
        Random random = new Random();
        this.id = random.nextInt(1, 10000);
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.minutesOfReading = minutesOfReading;
    }
}
