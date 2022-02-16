package kz.attractor.api.controller;

import kz.attractor.api.dto.SupplierDto;
import kz.attractor.api.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
