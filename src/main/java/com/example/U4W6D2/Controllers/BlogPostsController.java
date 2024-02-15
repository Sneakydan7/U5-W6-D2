package com.example.U4W6D2.Controllers;

import com.example.U4W6D2.Entities.Author;
import com.example.U4W6D2.Entities.BlogPost;
import com.example.U4W6D2.Payloads.BlogPostPayload;
import com.example.U4W6D2.Services.BlogPostSRV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {

    @Autowired
    private BlogPostSRV blogPostSRV;

    @GetMapping
    public Page<BlogPost> getBlogPosts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "postNumber") String orderBy) {
        return this.blogPostSRV.getBlogPosts(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return this.blogPostSRV.getBlogPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPostPayload newBlogPost) {
        return this.blogPostSRV.saveBlogPost(newBlogPost);
    }

    @PutMapping("/{id}")
    public BlogPost modifyBlogPostById(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        return this.blogPostSRV.modifyBlogPostById(updatedBlogPost, id);


    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPostById(@PathVariable Long id) {
        this.blogPostSRV.deleteBlogPostById(id);
    }

    @PostMapping("/upload/{id}")
    public String uploadImageForPost(@RequestParam("image") MultipartFile image, @PathVariable Long id) throws IOException {
        return this.blogPostSRV.uploadImageForPost(image, id);
    }
}
