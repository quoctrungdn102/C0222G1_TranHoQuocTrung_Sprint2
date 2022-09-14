package com.example.demo.service.cart;

import com.example.demo.model.order.Cart;
import com.example.demo.repository.cart.IRepositoryCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private IRepositoryCart iRepositoryCart;
    @Override
    public void createCart(Cart cart) {
        boolean check = true;
        List<Cart> list = listCart();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getProduct().getId().equals(cart.getProduct().getId())){
                 list.get(i).setQuality(list.get(i).getQuality()+1);;
                        iRepositoryCart.save(list.get(i));
                        check =false;
                        break;
            }
        }
        if(check){
                iRepositoryCart.save(cart);
        }
    }

    @Override
    public List<Cart> listCart() {
        return iRepositoryCart.findAll();
    }

    @Override
    public void subtractionCart(Cart cart) {
        List<Cart> list = listCart();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getProduct().getId().equals(cart.getProduct().getId())){
                if (list.get(i).getQuality()==1){
                    deleteCart(list.get(i));
                }else {
                    list.get(i).setQuality(list.get(i).getQuality()-1);;
                    iRepositoryCart.save(list.get(i));
                }
                break;

            }
        }
    }

    public void findCart(Cart cart) {
        iRepositoryCart.save(cart);
    }
    public void deleteCart(Cart cart){
        iRepositoryCart.delete(cart);
    }
}
