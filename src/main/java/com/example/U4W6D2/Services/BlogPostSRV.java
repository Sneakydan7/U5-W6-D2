package com.example.U4W6D2.Services;

import com.example.U4W6D2.Entities.Author;
import com.example.U4W6D2.Entities.BlogPost;
import com.example.U4W6D2.Exceptions.BadRequestException;
import com.example.U4W6D2.Exceptions.BlogNotFoundException;
import com.example.U4W6D2.Exceptions.NotFoundException;
import com.example.U4W6D2.Payloads.BlogPostPayload;
import com.example.U4W6D2.Repositories.AuthorsDAO;
import com.example.U4W6D2.Repositories.BlogPostsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogPostSRV {
    @Autowired
    public BlogPostsDAO blogPostsDAO;
    @Autowired
    public AuthorsSRV authorsSRV;
    @Autowired
    public AuthorsDAO authorsDAO;

    public Page<BlogPost> getBlogPosts(int pageNum, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(orderBy));
        return blogPostsDAO.findAll(pageable);
    }

    public BlogPost getBlogPostById(Long postNumber) {
        return blogPostsDAO.findByPostNumber(postNumber).orElseThrow(() -> new BlogNotFoundException(postNumber));

    }


    public BlogPost saveBlogPost(BlogPostPayload newBlogPost) {
        if (!authorsDAO.existsById(newBlogPost.getAuthorId())) throw new BadRequestException("Author not found");
        Author author = authorsSRV.getAuthorById(newBlogPost.getAuthorId());
        return blogPostsDAO.save(new BlogPost("Fiction", newBlogPost.getTitle(), "https://picsum.photos/200/300", newBlogPost.getContent(), 5, author));
    }

    public BlogPost modifyBlogPostById(BlogPost updatedBlogPost, Long id) {
        BlogPost found = this.getBlogPostById(id);
        found.setTitle(updatedBlogPost.getTitle());
        found.setAuthor(updatedBlogPost.getAuthor());
        found.setContent(updatedBlogPost.getContent());
        found.setCategory(updatedBlogPost.getCategory());
        found.setMinutesOfReading(updatedBlogPost.getMinutesOfReading());
        return blogPostsDAO.save(found);
    }

    public void deleteBlogPostById(Long id) {
        BlogPost found = this.getBlogPostById(id);
        blogPostsDAO.delete(found);
    }
}
