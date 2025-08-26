package com.example.shopkart_backend.entity;

public class CartProduct extends Product{

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
