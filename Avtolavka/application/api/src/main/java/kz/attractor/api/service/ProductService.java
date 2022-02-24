package kz.attractor.api.service;

import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    public Iterable<Product> findAllByName(String name) {
        return null;
    }

    public Product findById(int id) {
        return repository.getById(id);
    }
}
