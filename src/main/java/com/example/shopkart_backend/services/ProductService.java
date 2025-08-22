package com.example.shopkart_backend.services;

import com.example.shopkart_backend.entity.Product;
import com.example.shopkart_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }

    public Product updateProduct(int id,Product product){
        Product p = productRepository.findById(id).get();
        if(product.getName() != null){
            p.setName(product.getName());
        } else if (product.getDescription() != null) {
            p.setDescription(product.getDescription());
        } else if (product.getPrice() != 0) {
            p.setPrice(product.getPrice());
        }
        return productRepository.save(p);
    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductListByCategory(int id){

        return productRepository.findByCategoryId(id);

    }

}
