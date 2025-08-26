package com.example.shopkart_backend.controller;

import com.example.shopkart_backend.entity.Product;
import com.example.shopkart_backend.response.Response;
import com.example.shopkart_backend.services.CartService;
import com.example.shopkart_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @GetMapping("/api/v1/products/all")
    public Response getAllproducts(){
        Response response = new Response();
        response.setData(productService.getAllProducts());
        response.setMessage("product list fetched successfully");
        response.setSuccess(true);
        return response;
    }

    @GetMapping("/api/v1/products/category/{categoryId}")
    public Response getProductsByCategory(@PathVariable int categoryId){
        Response response = new Response();
        response.setData(productService.getProductListByCategory(categoryId));
        response.setMessage("product list fetched successfully");
        response.setSuccess(true);
        return response;
    }

    @GetMapping("/api/v1/products/{productId}")
    public Response getAllproductById(@PathVariable Integer productId){
        Response response = new Response();

        try{
            Product p= productService.getProductById(productId);
            response.setData(p);
            response.setMessage("product fetched successfully");
            response.setSuccess(true);
        }catch (NoSuchElementException e){
            response.setMessage("product not found");
            response.setSuccess(false);
        }


        return response;
    }

    @PostMapping("/api/v1/products")
    public Response createProduct(@RequestBody Product product){
        Response response = new Response();
        response.setData(productService.createProduct(product));
        response.setMessage("product created successfully");
        response.setSuccess(true);
        return response;
    }

    @DeleteMapping("/api/v1/products/{productId}")
    public Response deleteProductById(@PathVariable int productId){
        Response response = new Response();
        productService.deleteProductById(productId);
        response.setMessage("product deleted successfully");
        response.setSuccess(true);
        return response;
    }

    @PostMapping("/api/v1/carts/{cartId}")
    public Response addproductToCart(@PathVariable int cartId,@RequestBody Product product){
        Response response = new Response();
        cartService.addProductToCart(cartId,product);
        response.setSuccess(true);
        response.setMessage("Product successfully added to cart");
        return response;
    }





}
