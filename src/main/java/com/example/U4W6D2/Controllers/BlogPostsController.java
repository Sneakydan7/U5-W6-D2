package com.example.U4W6D2.Controllers;

import com.example.U4W6D2.Entities.BlogPost;
import com.example.U4W6D2.Services.BlogPostSRV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {

    @Autowired
    private BlogPostSRV blogPostSRV;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return this.blogPostSRV.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable int id) {
        return this.blogPostSRV.getBlogPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost newBlogPost) {
        return this.blogPostSRV.saveBlogPost(newBlogPost);
    }

    @PutMapping("/{id}")
    public BlogPost modifyBlogPostById(@PathVariable int id, @RequestBody BlogPost updatedBlogPost) {
        return this.blogPostSRV.modifyBlogPostById(updatedBlogPost, id);


    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPostById(@PathVariable int id) {
        this.blogPostSRV.deleteBlogPostById(id);
    }
}