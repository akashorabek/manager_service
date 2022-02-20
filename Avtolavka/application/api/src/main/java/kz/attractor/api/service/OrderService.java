package kz.attractor.api.service;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.Order;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.datamodel.repository.OrderProductsRepository;
import kz.attractor.datamodel.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductsRepository orderProductsRepository;
    private final ClientRepository clientRepository;

    public List<OrderDto> findAll() {
        var orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }

    public void add(OrderDto form) {
        Client client = clientRepository.findById(form.getId()).get();
        Order order = Order.builder()
                .dateCreation(LocalDateTime.now())
                .client(client)
                .build();
        orderRepository.save(order);
    }
}
