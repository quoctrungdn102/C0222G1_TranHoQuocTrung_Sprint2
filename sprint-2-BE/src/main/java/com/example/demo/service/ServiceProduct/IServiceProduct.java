package com.example.demo.service.ServiceProduct;

import com.example.demo.model.product.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> getAllProduct();
    List<Product> searchProduct(String id);
    Product findProductById(Integer id);

}
