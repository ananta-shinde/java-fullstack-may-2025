package com.example.shopkart_backend.services;

import com.example.shopkart_backend.entity.Cart;
import com.example.shopkart_backend.entity.Product;
import com.example.shopkart_backend.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addProductToCart(int cartId,Product product){
        Cart currentCart = cartRepository.findById(cartId).get();
        currentCart.getProducts().add(product);
        cartRepository.save(currentCart);
    }

}
