package kz.attractor.api.controller.frontendController;

import kz.attractor.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String root() {
        productService.findAll().forEach(System.out::println);
        return "index";
    }

    @GetMapping("products/send-price")
    public String showProductPrices(Model model) {
        var products = productService.findAllForPriceSend();
        model.addAttribute("products", products);
        return "products-with-prices";
    }

}
