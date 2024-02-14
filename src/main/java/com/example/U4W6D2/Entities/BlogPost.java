package com.example.U4W6D2.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Entity
@Table(name = "blog_posts")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_number", nullable = false)
    private Long postNumber;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int minutesOfReading;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public BlogPost(String category, String title, String cover, String content, int minutesOfReading) {
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.minutesOfReading = minutesOfReading;
    }
}
