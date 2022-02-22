package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public String showOrdersPage(Model model) {
        List<OrderDto> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }
}
