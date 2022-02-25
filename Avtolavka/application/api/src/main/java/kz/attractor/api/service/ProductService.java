package kz.attractor.api.service;

import kz.attractor.api.dto.ProductDto;
import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.model.ProductSpecification;
import kz.attractor.datamodel.repository.ProductRepository;
import kz.attractor.datamodel.util.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Iterable<Product> findAllByName(String name) {
        ProductSpecification nameLike = new ProductSpecification(new SearchCriteria("name", ":", name ));
        return repository.findAll(nameLike);
    }

    public Product findById(int id) {
        return repository.getById(id);
    }

    public List<ProductDto> findAllForPriceSend() {
        List<Product> products = productRepository.findAllByWarehouse_IncludeToPriceList(true);
        return products.stream().map(ProductDto::from)
                .collect(Collectors.toList());
    }
}
