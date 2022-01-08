package com.kivanc.spring.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_in_stock")
    private String productInStock;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "shippable")
    private Boolean shippable;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(String productInStock) {
        this.productInStock = productInStock;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Boolean getShippable() {
        return shippable;
    }

    public void setShippable(Boolean shippable) {
        this.shippable = shippable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + id +
                ", productName='" + productName + '\'' +
                ", productInStock='" + productInStock + '\'' +
                ", productPrice=" + productPrice +
                ", shippable=" + shippable +
                '}';
    }
}
