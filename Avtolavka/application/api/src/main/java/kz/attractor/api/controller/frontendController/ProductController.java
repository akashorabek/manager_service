package kz.attractor.api.controller.frontendController;

import kz.attractor.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;



    @GetMapping("/products")
    public String showProductsPage(Model model,
                                   @RequestParam(required = false) String query,
                                   @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        model.addAttribute("page", productService.findAll(query, pageable));
        if(query != null) {
            model.addAttribute("link", query);
        }
        return "products";
    }

    @GetMapping("products/send-price")
    public String showProductPrices(Model model) {
        var products = productService.findAllForPriceSend();
        model.addAttribute("products", products);
        return "products-with-prices";
    }
}
