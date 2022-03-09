package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.SupplierDto;
import kz.attractor.api.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService service;

    @GetMapping("/suppliers")
    public String showSuppliersPage(Model model) {
        List<SupplierDto> suppliers = service.findAll();
        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @PostMapping("/suppliers")
    private String createSupplier(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String partner,
            @RequestParam String shipment
    ){
        return service.create(name, email, partner, shipment);
    }
}
