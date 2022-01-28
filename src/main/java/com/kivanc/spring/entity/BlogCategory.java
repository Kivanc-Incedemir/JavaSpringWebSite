package com.kivanc.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "blog_category")
public class BlogCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="category",nullable = false)
    private String category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "blog_categories",
            joinColumns = @JoinColumn(name = "blog_category_id"),
            inverseJoinColumns = @JoinColumn(name = "blog_post_id"))
    private Collection<BlogPost> blogPosts;
}