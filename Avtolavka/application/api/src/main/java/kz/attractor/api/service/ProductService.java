package kz.attractor.api.service;

import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.model.ProductSpecification;
import kz.attractor.datamodel.repository.ProductRepository;
import kz.attractor.datamodel.util.SearchCriteria;
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
        ProductSpecification nameLike = new ProductSpecification(new SearchCriteria("name", ":", name ));
        return repository.findAll(nameLike);
    }

    public Product findById(int id) {
        return repository.getById(id);
    }
}
