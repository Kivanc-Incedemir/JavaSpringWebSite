package com.kivanc.spring.service;

import com.kivanc.spring.entity.Product;

import java.util.List;

public interface ProductService{

    public List<Product> findAllProducts();

    public Product findProductById(int productId);

    public void deleteProductById(int productId);

    public void save(Product product);
}
