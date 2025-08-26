package com.example.shopkart_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;


public class Order {


    private int id;
    private List<Product> products;
    private double total;
    private String status;
    private int sellerId;


}
