package com.example.shopkart_backend.services;

import com.example.shopkart_backend.entity.Cart;
import com.example.shopkart_backend.entity.Customer;
import com.example.shopkart_backend.entity.User;
import com.example.shopkart_backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public List<User> getUsersList(){
        return (List<User>)userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).get();
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User createUser(User user){
        Cart cart = new Cart();
        user.setCart(cart);
        if(user.getRole().getId() == 1) {
            user.setRole(roleRepository.findById(1).get());
            User newuser = userRepository.save(user);
            Customer customer = new Customer();
            customer.setUser(newuser);
             customerRepository.save(customer);
        }
        return null;
    }

    public User resetPassword(User user){
        User u = userRepository.findByEmail(user.getEmail());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return u;
    }
}
