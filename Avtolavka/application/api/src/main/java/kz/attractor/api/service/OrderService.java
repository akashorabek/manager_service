package kz.attractor.api.service;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.api.dto.OrderDtoAdd;
import kz.attractor.api.exception.ObjectDontExistException;
import kz.attractor.datamodel.model.*;
import kz.attractor.datamodel.repository.*;
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
    private final OrderProductRepository orderProductRepository;
    private final ContactRepository contactRepository;
    private final ProductRepository productRepository;

    public Page<OrderDto> findAll(Pageable pageable) {
        Page<Order> ordersPage = orderRepository.findAll(pageable);
        return new PageImpl<OrderDto>(
                ordersPage.getContent().stream()
                        .map(OrderDto::from)
                        .collect(Collectors.toList()),
                pageable, ordersPage.getTotalElements()
        );
    }

    public void add(OrderDtoAdd form) {
        Contact contact = contactRepository.findById(form.getContactId()).get();
        Order order = Order.builder()
                .dateCreation(LocalDateTime.now())
                .contact(contact)
                .isClosed(false)
                .build();
        orderRepository.save(order);

        for(int i = 0; i < form.getQuantities().size(); i++) {
            Product product = productRepository.findById(form.getProductIds().get(i)).get();
            OrderProduct orderProduct = OrderProduct.builder()
                    .product(product)
                    .order(order)
                    .quantity(form.getQuantities().get(i))
                    .build();
            orderProductRepository.save(orderProduct);
        }
    }

    public Order findById(Long id) {
        var order = orderRepository.findById(id).orElseThrow( () ->
                new ObjectDontExistException("Заказ с id " + id + " отсутствует"));
        return order;
    }

    public List<OrderProduct> findOrderProductsByOrderId(Long id) {
        return orderProductRepository.findAllByOrderId(id);
    }

    public void closeStatus(long orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setClosed(true);
        orderRepository.save(order);
    }
}
