package com.kivanc.spring.dao;

import com.kivanc.spring.entity.Product;
import com.kivanc.spring.entity.User;

import java.util.List;

public interface ProductDao {

    public List<Product> findAllProducts();

    public Product findProductById(int Id);

    public void deleteProductById(int Id);

    public void save(Product product);


}
