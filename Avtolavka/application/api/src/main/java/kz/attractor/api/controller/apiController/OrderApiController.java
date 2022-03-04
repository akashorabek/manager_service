package kz.attractor.api.controller.apiController;

import kz.attractor.api.dto.OrderDtoAdd;
import kz.attractor.api.service.OrderService;
import kz.attractor.datamodel.model.Order;
import kz.attractor.datamodel.model.OrderProducts;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
public class OrderApiController {
    private final OrderService orderService;

    @GetMapping("/api/orders/{id}")
    public HashMap<String, Object> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        List<OrderProducts> orderProducts = orderService.findOrderProductsByOrderId(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("order", order);
        hashMap.put("orderProducts", orderProducts);
        return hashMap;
    }

    @PostMapping("/orders/add")
    public void addOrder(OrderDtoAdd orderDtoAdd) {
        orderService.add(orderDtoAdd);
    }
}
