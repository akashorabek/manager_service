package kz.attractor.api.controller.frontendController;

import kz.attractor.api.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String root() {
        productService.findAll().forEach(System.out::println);
        return "index";
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @PostMapping("/products")
    public String searchProducts(@RequestParam String query, Model model) {
        model.addAttribute("products", productService.findAllByName(query));
        return "products";
    }

    @GetMapping("products/send-price")
    public String showProductPrices(Model model) {
        var products = productService.findAllForPriceSend();
        model.addAttribute("products", products);
        return "products-with-prices";
    }
}
