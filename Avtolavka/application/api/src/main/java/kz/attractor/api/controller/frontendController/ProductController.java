package kz.attractor.api.controller.frontendController;

import kz.attractor.api.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @GetMapping
    public String root() {
        service.findAll().forEach(System.out::println);
        return "index";
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", service.findAll());
        return "products";
    }
}
