package com.example.demo.repository.cart;

import com.example.demo.model.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IRepositoryCart extends JpaRepository<Cart,Integer> {
}
