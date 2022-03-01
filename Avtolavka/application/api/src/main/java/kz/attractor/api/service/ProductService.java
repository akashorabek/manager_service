package kz.attractor.api.service;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.api.dto.ProductDto;
import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.model.ProductSpecification;
import kz.attractor.datamodel.repository.ProductRepository;
import kz.attractor.datamodel.util.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<ProductDto> findAll(String query, Pageable pageable) {
        if (query != null) {
            ProductSpecification nameLike = new ProductSpecification(new SearchCriteria("name", ":", query));
            Page<Product> productPage = productRepository.findAll(nameLike, pageable);
            return new PageImpl<ProductDto>(
                    productPage.getContent().stream()
                            .map(ProductDto::from)
                            .collect(Collectors.toList()),
                    pageable, productPage.getTotalElements()
            );
        }
        Page<Product> productPage = productRepository.findAll(pageable);
        return new PageImpl<ProductDto>(
                productPage.getContent().stream()
                        .map(ProductDto::from)
                        .collect(Collectors.toList()),
                pageable, productPage.getTotalElements()
        );
    }

    public List<ProductDto> findAll(String query) {
        ProductSpecification nameLike = new ProductSpecification(new SearchCriteria("name", ":", query));
        List<Product> products = productRepository.findAll(nameLike);
        return products.stream()
                .map(ProductDto::from)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDto::from)
                .collect(Collectors.toList());
    }

    public Product findById(int id) {
        return productRepository.getById(id);
    }

    public List<ProductDto> findAllForPriceSend() {
        List<Product> products = productRepository.findAllByWarehouse_IncludeToPriceList(true);
        return products.stream().map(ProductDto::from)
                .collect(Collectors.toList());
    }
}
