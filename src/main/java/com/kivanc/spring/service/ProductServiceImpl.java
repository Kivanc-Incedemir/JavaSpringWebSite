package com.kivanc.spring.service;

import com.kivanc.spring.dao.ProductDao;
import com.kivanc.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    @Transactional
    public Product findProductById(int productId) {


        return productDao.findProductById(productId);
    }


    @Override
    @Transactional
    public void deleteProductById(int productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    @Transactional
    public void save(Product product) {

        Product theProduct = new Product();


        theProduct.setProductName(product.getProductName());
        theProduct.setProductPrice(product.getProductPrice());
        theProduct.setProductInStock(product.getProductInStock());
        theProduct.setShippable(product.getShippable());

        productDao.save(theProduct);
    }
}
