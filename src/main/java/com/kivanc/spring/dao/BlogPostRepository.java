package com.kivanc.spring.dao;

import com.kivanc.spring.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {



}