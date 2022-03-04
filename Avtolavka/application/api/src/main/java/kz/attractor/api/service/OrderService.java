package kz.attractor.api.service;

import kz.attractor.api.dto.OrderDto;
import kz.attractor.api.dto.OrderDtoAdd;
import kz.attractor.api.exception.ObjectDontExistException;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.Order;
import kz.attractor.datamodel.model.OrderProduct;
import kz.attractor.datamodel.model.Product;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.datamodel.repository.OrderProductRepository;
import kz.attractor.datamodel.repository.OrderRepository;
import kz.attractor.datamodel.repository.ProductRepository;
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
    private final ClientRepository clientRepository;
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
        Client client = clientRepository.findById(form.getClientId()).get();
        Order order = Order.builder()
                .dateCreation(LocalDateTime.now())
                .client(client)
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
}
