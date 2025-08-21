package com.example.shopkart_backend.controller;

import com.example.shopkart_backend.entity.User;
import com.example.shopkart_backend.repositories.UserRepository;
import com.example.shopkart_backend.response.Response;
import com.example.shopkart_backend.response.UserResponse;
import com.example.shopkart_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // get all users
    @GetMapping("/api/v1/users/all")
    Response getAllUsers(){
        Response response = new Response();
        response.setData(userService.getUsersList());
        response.setSuccess(true);
        response.setMessage("fetched list of all users");
        return response;
    }

    // get user by id
    @GetMapping("/api/v1/users/{userid}")
    Response getUserById(@PathVariable String userid){
        Response response = new Response();
        try {
            response.setData(userService.getUserById(userid));
            response.setSuccess(true);
            response.setMessage("user fetched successfully");
        }catch (NoSuchElementException e){
            response.setSuccess(false);
            response.setMessage("user does not exists");
        }
        return response;
    }

    // get user by email
    @GetMapping("/api/v1/users")
    Response getUserByEmail(@RequestParam String email)
    {
        Response response = new Response();
        User user = userService.getUserByEmail(email);
        if(user != null) {
            response.setData(user);
            response.setSuccess(true);
            response.setMessage("user fetched successfully");
        }else{
            response.setSuccess(false);
            response.setMessage("user does not exists");
        }
        return response;
    }

    private UserResponse prepareUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        return userResponse;
    }


}
