package com.example.shopkart_backend.repositories;

import com.example.shopkart_backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    User findByEmail(String email);
    List<User> findByIsActiveTrue();
}
