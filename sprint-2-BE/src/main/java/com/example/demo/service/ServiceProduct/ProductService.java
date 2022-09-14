package com.example.demo.service.ServiceProduct;

import com.example.demo.model.product.Product;
import com.example.demo.repository.repositoryProduct.IRepositoriProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IServiceProduct{
    @Autowired
    private IRepositoriProduct iRepositoriProduct;
    @Override
    public List<Product> getAllProduct() {
        return iRepositoriProduct.findAll();
    }

    @Override
    public List<Product> searchProduct(String id) {
        return iRepositoriProduct.searchProduct('%'+ id + '%');
    }

    @Override
    public Product findProductById(Integer id) {
        return iRepositoriProduct.findById(id).get();
    }

}
