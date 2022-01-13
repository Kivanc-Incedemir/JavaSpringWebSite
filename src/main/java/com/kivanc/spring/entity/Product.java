package com.kivanc.spring.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO ,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_in_stock")
    private int productInStock;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "shippable")
    private Boolean shippable;

    public Product() {
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
