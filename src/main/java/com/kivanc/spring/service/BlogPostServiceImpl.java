package com.kivanc.spring.service;

import com.kivanc.spring.dao.BlogCategoryRepository;
import com.kivanc.spring.dao.BlogPostRepository;
import com.kivanc.spring.entity.BlogCategory;
import com.kivanc.spring.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService{


    @Autowired
    BlogPostRepository blogPostRepository;
    @Autowired
    BlogCategoryRepository blogCategoryRepository;

    @Override
    @Transactional
    public List<BlogPost> findAllBlogPosts() {

        return blogPostRepository.findAll();
    }


    @Override
    @Transactional
    public BlogPost findBlogPostById(Integer blogPostId) {

        Optional<BlogPost> result = blogPostRepository.findById(blogPostId);

        BlogPost blogPost = null;

        if(result.isPresent()){
            blogPost = result.get();
        } else{
            throw new RuntimeException("Did not find blog post id - " + blogPostId);
        }


        return blogPost;
    }

    @Override
    @Transactional
    public void deleteBlogPostById(Integer blogPostId) {

        BlogPost blogPost = findBlogPostById(blogPostId);

        blogPostRepository.delete(blogPost);
    }

    @Override
    @Transactional
    public void save(BlogPost blogPost,int theId) {

        Optional<BlogCategory> result = blogCategoryRepository.findById(theId);

        BlogCategory theBlogCategory = null;

        if(result.isPresent()){
            theBlogCategory = result.get();
        } else{
            throw new RuntimeException("Did not find blog category id - " + theId);
        }

        blogPost.setBlogCategories(Arrays.asList(theBlogCategory));

        blogPostRepository.save(blogPost);
    }
}
