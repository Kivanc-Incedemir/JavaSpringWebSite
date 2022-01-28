package com.kivanc.spring.service;

import com.kivanc.spring.entity.BlogCategory;
import com.kivanc.spring.entity.BlogPost;

import java.util.List;

public interface BlogCategoryService {

    public List<BlogCategory> findAllBlogCategories();

    public BlogCategory findBlogCategoryById(Integer blogCategoryId);

    public void deleteBlogCategoryById(Integer blogCategoryId);

    public void save(BlogCategory blogCategory);
}
