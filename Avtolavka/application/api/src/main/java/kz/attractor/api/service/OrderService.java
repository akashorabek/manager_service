package kz.attractor.api.service;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.Order;
import kz.attractor.datamodel.model.OrderProducts;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.datamodel.repository.OrderProductsRepository;
import kz.attractor.datamodel.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<OrderDto> findAll(Pageable pageable) {
        Page<Order> ordersPage = orderRepository.findAll(pageable);
        return new PageImpl<OrderDto>(
                ordersPage.getContent().stream()
                        .map(OrderDto::from)
                        .collect(Collectors.toList()),
                pageable, ordersPage.getTotalElements()
        );
    }

    public void add(OrderDto form) {
        Client client = clientRepository.findById(form.getId()).get();
        Order order = Order.builder()
                .dateCreation(LocalDateTime.now())
                .client(client)
                .build();
        orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.getById(id);
    }

    public List<OrderProducts> findOrderProductsByOrderId(Long id) {
        return orderProductsRepository.findAllByOrderId(id);
    }
}
