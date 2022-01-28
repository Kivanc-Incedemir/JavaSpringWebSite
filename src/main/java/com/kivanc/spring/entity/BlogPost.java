package com.kivanc.spring.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name="img", nullable = false,length = 30)
    private String img;

    @Column(name="date",nullable = false)
    private LocalDate  postDate;

    @Column(name="title",nullable = false ,length = 30)
    private String title;

    @Column(name="content",nullable = false ,length = 30)
    private String content;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "blog_categories",
            joinColumns = @JoinColumn(name = "blog_post_id"),
            inverseJoinColumns = @JoinColumn(name = "blog_category_id"))
    private Collection<BlogCategory> blogCategories;

}
