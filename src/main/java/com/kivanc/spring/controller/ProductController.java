package com.kivanc.spring.controller;

import com.kivanc.spring.entity.Product;
import com.kivanc.spring.service.ProductService;
import com.kivanc.spring.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public String listProducts(Model theModel) {

        List<Product> theProducts = productService.findAllProducts();

        theModel.addAttribute("products",theProducts);


        return "products/list-products";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel ) {

        Product theEmployee = new Product();

        theModel.addAttribute("employee",theEmployee);

        return "products/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel)
    {
        Product theEmployee = productService.findProductById(theId);

        theModel.addAttribute("employee",theEmployee);

        return "products/employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Product theEmployee) {
        productService.save(theEmployee);

        return "redirect:/products/list";

    }

    @GetMapping("delete")
    public String delete(@RequestParam("employeeId") int theId)
    {
        productService.deleteProductById(theId);

        return "redirect:/products/list";
    }
}
