package com.example.demo.model.order;

import com.example.demo.model.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userCustomer;
    private Integer statusDelete = 0;
    private Integer quality;
    @ManyToOne(targetEntity = Product.class)
    private Product product;

    public Cart() {
    }

    public Cart(Integer id, String userCustomer, Integer statusDelete, Integer quality, Product product) {
        this.id = id;
        this.userCustomer = userCustomer;
        this.statusDelete = statusDelete;
        this.quality = quality;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(String userCustomer) {
        this.userCustomer = userCustomer;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
