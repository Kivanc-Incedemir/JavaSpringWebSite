package com.kivanc.spring.controller;

import com.kivanc.spring.entity.BlogCategory;
import com.kivanc.spring.entity.BlogPost;
import com.kivanc.spring.service.BlogCategoryService;
import com.kivanc.spring.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogPostService blogPostService;

    @Autowired
    BlogCategoryService blogCategoryService;


    @GetMapping("/list")
    public String listPosts(Model theModel, Authentication authentication) {

        List<BlogPost> theBlogPosts = blogPostService.findAllBlogPosts();

        theModel.addAttribute("blogPosts",theBlogPosts);

        return "blogs/blog-list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd( Model theModel ) {

        BlogPost theBlogPost = new BlogPost();

        List<BlogCategory> blogCategories = blogCategoryService.findAllBlogCategories();
        theModel.addAttribute("blogCategories",blogCategories);
        theModel.addAttribute("blogPost",theBlogPost);

        return "blogs/blog-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("blogPostId") int theId,
                                    Model theModel)
    {
        BlogPost theBlogPost  = blogPostService.findBlogPostById(theId);
        List<BlogCategory> blogCategories = blogCategoryService.findAllBlogCategories();
        theModel.addAttribute("blogPost",theBlogPost);
        theModel.addAttribute("blogCategories",blogCategories);
        return "blogs/blog-form";

    }

    @PostMapping("/save")
    public String saveBlogPost(@RequestParam("BlogCategoryId")int theId,@ModelAttribute("blogPost") BlogPost theBlogPost) {



        blogPostService.save(theBlogPost,theId);

        return "redirect:/admin/";

    }

    @GetMapping("delete")
    public String delete(@RequestParam("blogPostId") int theId)
    {
        blogPostService.deleteBlogPostById(theId);

        return "redirect:/admin/";
    }
}
