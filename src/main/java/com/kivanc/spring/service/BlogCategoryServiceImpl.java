package com.kivanc.spring.service;

import com.kivanc.spring.dao.BlogCategoryRepository;
import com.kivanc.spring.dao.BlogPostRepository;
import com.kivanc.spring.entity.BlogCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService{


    @Autowired
    BlogCategoryRepository blogCategoryRepository;

    @Override
    public List<BlogCategory> findAllBlogCategories() {
        return blogCategoryRepository.findAll();
    }

    @Override
    public BlogCategory findBlogCategoryById(Integer blogCategoryId) {
        return null;
    }

    @Override
    public void deleteBlogCategoryById(Integer blogCategoryId) {

    }

    @Override
    public void save(BlogCategory blogCategory) {

    }
}
