package com.example.shopkart_backend.controller;

import com.example.shopkart_backend.entity.User;
import com.example.shopkart_backend.response.Response;
import com.example.shopkart_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/users/register")
    public Response  resgisterUser(@RequestBody User user){
        Response response = new Response();
        try{
            response.setData(userService.createUser(user));
            response.setMessage("user registered successfully");
            response.setSuccess(true);
        }catch (DataIntegrityViolationException e){
            response.setMessage("user already exists");
            response.setSuccess(false);
        }

          return response;
    }

    @PostMapping("/api/v1/users/signin")
    public Response  signInUser(@RequestBody User user){
        User u = userService.getUserByEmail(user.getEmail());
        Response response = new Response();
        if(u == null){
            response.setSuccess(false);
            response.setMessage("invalid creds");
        }else{
            if(u.getPassword().equals(user.getPassword())){
                response.setData(u);
                response.setSuccess(true);
                response.setMessage("user login successful");
            }else{
                response.setSuccess(false);
                response.setMessage("invalid creds");
            }
        }
        return response;
    }

    @PostMapping("/api/v1/users/resetpassword")
    public Response resetPassword(@RequestBody User user){
        Response response = new Response();
        response.setData(userService.resetPassword(user));
        response.setSuccess(true);
        response.setMessage("password reset successful");
        return response;
    }

}
