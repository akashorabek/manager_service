package kz.attractor.api.service;

import kz.attractor.api.dto.ProductDto;
import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.repository.ProductRepository;
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
//        return repository.findAllByName(name);
        return null;
    }

    public List<ProductDto> findAllForPriceSend() {
        List<Product> products = productRepository.findAllByWarehouse_IncludeToPriceList(true);
        return products.stream().map(ProductDto::from)
                .collect(Collectors.toList());
    }
}
