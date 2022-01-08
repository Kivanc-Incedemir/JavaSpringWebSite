package com.kivanc.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productInStock")
    private String productInStock;

    @Column(name = "productPrice")
    private BigDecimal productPrice;

    @Column(name = "shippable")
    private Boolean shippable;

    public Product() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
                "Id=" + Id +
                ", productName='" + productName + '\'' +
                ", productInStock='" + productInStock + '\'' +
                ", productPrice=" + productPrice +
                ", shippable=" + shippable +
                '}';
    }
}