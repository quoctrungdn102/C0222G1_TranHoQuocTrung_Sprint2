package com.example.demo.model.category;

import com.example.demo.model.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_deleted")
    private int isDelete = 0;

    private String logo;

    @OneToMany(mappedBy = "category")
    @JsonBackReference("category")
    private Set<Product> products;

    public Category() {
    }

    public Category(Integer id, String name, int isDelete, String logo, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.logo = logo;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
