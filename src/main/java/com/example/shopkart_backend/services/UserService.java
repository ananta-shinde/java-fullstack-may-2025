package com.example.shopkart_backend.services;

import com.example.shopkart_backend.entity.User;
import com.example.shopkart_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
           return userRepository.save(user);
    }

    public User resetPassword(User user){
        User u = userRepository.findByEmail(user.getEmail());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return u;
    }
}
