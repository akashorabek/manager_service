package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.api.service.ClientService;
import kz.attractor.api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ClientService clientService;

    @GetMapping("/orders")
    public String showOrdersPage(Model model,
                                 @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        Page<OrderDto> orders = orderService.findAll(pageable);
        model.addAttribute("page", orders);
        model.addAttribute("clients", clientService.findAll());
        return "orders";
    }

    @GetMapping("/orders/add")
    public String showAddOrdersPage() {
        return "order_add";
    }


}
