package com.example.demo.repository.repositoryProduct;

import com.example.demo.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IRepositoriProduct extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM product where category_id like :categoryId", nativeQuery = true)
    List<Product> searchProduct(
            @Param("categoryId") String idProduct
    );
}
