package com.example.session07.service;

import com.example.session07.model.Category;
import com.example.session07.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id);
    }

    public boolean save(Category category){
        return categoryRepository.save(category);
    }

    public boolean deleteById(Long id){
        return categoryRepository.delete(id);
    }

    public boolean existsByCateName(String cateName){
        return categoryRepository.existsByCateName(cateName);
    }
}
