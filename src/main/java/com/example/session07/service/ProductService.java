package com.example.session07.service;

import com.example.session07.model.Product;
import com.example.session07.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product findById(Long id) {
        return productRepository.findById(id);
    }


    public boolean save(Product product) {
        return productRepository.save(product);
    }


    public boolean deleteById(Long id) {
        return productRepository.deleteById(id);
    }


    public boolean checkProductNameExists(String productName) {
        return productRepository.checkProductNameExists(productName);
    }


}
