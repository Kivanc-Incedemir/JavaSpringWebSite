package com.kivanc.spring.dao;

import com.kivanc.spring.entity.Product;
import com.kivanc.spring.entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> findAllProducts() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Product> theQuery = currentSession.createQuery("  from Product",Product.class);

        List<Product> productList = null;

        try{
            productList = theQuery.getResultList();
        } catch (Exception e){
            productList = null;
        }

        return productList;
    }

    @Override
    public Product findProductById(int theProductId) {

        Session currentSession = entityManager.unwrap(Session.class);


        // now retrieve/read from database using name
        Query<Product> theQuery = currentSession.createQuery("from Product where id=:productId", Product.class);
        theQuery.setParameter("productId", theProductId);

        Product product = null;

        try {
            product = theQuery.getSingleResult();
        } catch (Exception e) {
            product = null;
        }

        return product;
    }

    @Override
    public void deleteProductById(int Id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Product product = findProductById(Id);

        currentSession.delete(product);
    }

    @Override
    public void save(Product product) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(product);
    }
}
