package com.example.manager.service;

import com.example.manager.model.Product;
import com.example.manager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Iterable<Product> findAll() {
        return repository.findAll();
    }
}
