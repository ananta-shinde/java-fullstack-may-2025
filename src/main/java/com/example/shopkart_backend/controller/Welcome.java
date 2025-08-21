package com.example.shopkart_backend.controller;

import com.example.shopkart_backend.entity.User;
import com.example.shopkart_backend.repositories.UserRepository;
import com.example.shopkart_backend.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class Welcome {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String displayMessage(){
        return "Welcome to Spring boot";
    }

    @PostMapping("/signup")
    public String registerUser(@RequestBody User user){
        System.out.println(user.getEmail());
        userRepository.save(user);
        return "user created success";
    }
}
