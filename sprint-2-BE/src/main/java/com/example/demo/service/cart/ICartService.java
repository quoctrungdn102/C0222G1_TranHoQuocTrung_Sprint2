package com.example.demo.service.cart;

import com.example.demo.model.order.Cart;
import com.example.demo.model.product.Product;

import java.util.List;

public interface ICartService {
    void createCart(Cart cart);

    List<Cart> listCart();

    void subtractionCart(Cart cart);

    void deleteCart(Cart cart);
}
