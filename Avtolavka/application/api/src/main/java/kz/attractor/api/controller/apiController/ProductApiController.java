package kz.attractor.api.controller.apiController;

import kz.attractor.api.service.ProductService;
import kz.attractor.datamodel.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductApiController {
    private final ProductService service;

    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.findById(id);
    }
}
