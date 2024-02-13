package com.example.U4W6D2.Services;

import com.example.U4W6D2.Entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogPostSRV {

    public List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getAllBlogPosts() {
        return this.blogPosts;
    }

    public BlogPost getBlogPostById(int id) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                found = blogPost;
            }
        }
        return found;
    }


    public BlogPost saveBlogPost(BlogPost blogPost) {
        this.blogPosts.add(blogPost);
        return blogPost;
    }


    public BlogPost modifyBlogPostById(BlogPost updatedBlogPost, int id) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                found = blogPost;
                found.setCategory(updatedBlogPost.getCategory());
                found.setCover(updatedBlogPost.getCover());
                found.setTitle(updatedBlogPost.getTitle());
                found.setContent(updatedBlogPost.getContent());
                found.setMinutesOfReading(updatedBlogPost.getMinutesOfReading());
            }

        }
        return found;
    }

    public void deleteBlogPostById(int id) {
        Iterator<BlogPost> iterator = this.blogPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
