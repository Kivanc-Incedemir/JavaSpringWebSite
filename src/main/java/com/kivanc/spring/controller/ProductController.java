package com.kivanc.spring.controller;

import com.kivanc.spring.entity.Product;
import com.kivanc.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public String listProducts(Model theModel, Authentication authentication) {

        List<Product> theProducts = productService.findAllProducts();

        theModel.addAttribute("products",theProducts);
        theModel.addAttribute("username",authentication.getName());



        return "products/product-list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel ) {

        Product theProduct = new Product();

        theModel.addAttribute("product",theProduct);

        return "products/product-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId,
                                    Model theModel)
    {
        Product theProduct = productService.findProductById(theId);

        theModel.addAttribute("product",theProduct);

        return "products/product-form";

    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product theProduct) {
        productService.save(theProduct);
        System.out.println("Hey");
        return "redirect:/user/";

    }

    @GetMapping("delete")
    public String delete(@RequestParam("productId") int theId)
    {
        productService.deleteProductById(theId);

        return "redirect:/user/";
    }
}
