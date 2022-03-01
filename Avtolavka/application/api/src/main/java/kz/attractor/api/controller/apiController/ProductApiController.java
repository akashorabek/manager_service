package kz.attractor.api.controller.apiController;

import kz.attractor.api.dto.ProductDto;
import kz.attractor.api.service.ProductService;
import kz.attractor.datamodel.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductApiController {
    private final ProductService service;

    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/api/products")
    public List<ProductDto> showProductsPage(Model model,
                                             @RequestParam(required = false) String query) {
        if (query != null) {
            return service.findAll(query);
        }
        return service.findAll();
    }
}
