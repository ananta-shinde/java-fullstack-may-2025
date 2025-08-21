package com.example.shopkart_backend.controller;

import com.example.shopkart_backend.entity.Category;
import com.example.shopkart_backend.entity.Product;
import com.example.shopkart_backend.response.Response;
import com.example.shopkart_backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/v1/categories/all")
    public Response getAllCategories(){
        Response response = new Response();
        response.setData(categoryService.getAllCategories());
        response.setMessage("category list fetched successfully");
        response.setSuccess(true);
        return response;
    }

    @GetMapping("/api/v1/categories/{categoryId}")
    public Response getCategoryById(@PathVariable Integer categoryId) {
        Response response = new Response();

        try {
            Category p = categoryService.getCategoryById(categoryId);
            response.setData(p);
            response.setMessage("Category fetched successfully");
            response.setSuccess(true);
        } catch (NoSuchElementException e) {
            response.setMessage("Category not found");
            response.setSuccess(false);
        }

        return response;
    }


        @PostMapping("/api/v1/categories")
        public Response createCategory(@RequestBody Category category){
            Response response = new Response();
            response.setData(categoryService.createCategory(category));
            response.setMessage("product created successfully");
            response.setSuccess(true);
            return response;
        }

    @DeleteMapping("/api/v1/categories/{categoryId}")
    public Response deleteProductById(@PathVariable int categoryId){
        Response response = new Response();
        categoryService.deleteCategoryById(categoryId);
        response.setMessage("category deleted successfully");
        response.setSuccess(true);
        return response;
    }

    }
