package com.kivanc.spring.service;

import com.kivanc.spring.entity.BlogPost;
import com.kivanc.spring.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogPostService {
    public List<BlogPost> findAllBlogPosts();

    public BlogPost findBlogPostById(Integer blogPostId);

    public void deleteBlogPostById(Integer blogPostId);

    public void save(BlogPost blogPost,int theId);
}
