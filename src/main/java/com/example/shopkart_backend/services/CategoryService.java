package com.example.shopkart_backend.services;

import com.example.shopkart_backend.entity.Category;
import com.example.shopkart_backend.entity.Product;
import com.example.shopkart_backend.repositories.CategoryRepository;
import com.example.shopkart_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id){
        return categoryRepository.findById(id).get();
    }

    public Category updateCategory(int id,Category category){
        Category p = categoryRepository.findById(id).get();
        if(category.getName() != null){
            p.setName(category.getName());
        } else if (category.getDescription() != null) {
            p.setDescription(category.getDescription());
        }
        return categoryRepository.save(p);
    }

    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }

}
