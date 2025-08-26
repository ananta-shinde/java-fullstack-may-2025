package com.example.shopkart_backend.repositories;

import com.example.shopkart_backend.entity.Seller;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
