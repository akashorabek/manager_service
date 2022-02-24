package kz.attractor.datamodel.util;

import kz.attractor.datamodel.model.*;
import kz.attractor.datamodel.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Configuration
@AllArgsConstructor
public class DataInit {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderProductsRepository orderProductsRepository;
    private final WarehouseRepository warehouseRepository;

    @Bean
    public CommandLineRunner init() {
        try {
            initClients().run();
            initContacts().run();
            initSuppliers().run();
            initProducts().run();
            initOrders().run();
            initOrdersProducts().run();
            initWarehouses().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private CommandLineRunner initWarehouses() {
        return (args -> Stream.of(warehouses())
                .peek(System.out::println)
                .forEach(warehouseRepository::save));
    }

    private CommandLineRunner initProducts() {
        return (args -> Stream.of(products())
                .peek(System.out::println)
                .forEach(productRepository::save));
    }

    private CommandLineRunner initClients() {
        return (args) -> Stream.of(clients())
                .peek(System.out::println)
                .forEach(clientRepository::save);
    }

    private CommandLineRunner initContacts() {
        return (args) -> Stream.of(contacts())
                .peek(System.out::println)
                .forEach(contactRepository::save);
    }

    private CommandLineRunner initSuppliers() {
        return (args) -> Stream.of(suppliers())
                .peek(System.out::println)
                .forEach(supplierRepository::save);
    }

    private CommandLineRunner initOrders() {
        return (args) -> Stream.of(orders())
                .peek(System.out::println)
                .forEach(orderRepository::save);
    }

    private CommandLineRunner initOrdersProducts() {
        return (args) -> Stream.of(ordersProducts())
                .peek(System.out::println)
                .forEach(orderProductsRepository::save);
    }

    private Warehouse[] warehouses() {
        return new Warehouse[]{
                new Warehouse(1L, "Склад в Алматы", true),
                new Warehouse(2L, "Склад в Шымкенте", true),
                new Warehouse(3L, "Нет склада", false)
        };
    }

    private Contact[] contacts() {
        return new Contact[]{
                new Contact(1L, "Рыжова Оксана", "222", "a@mail.ru",
                        ContactStatus.CONTACT_ARCHIVE,
                        clientRepository.getById(1L)),
                new Contact(2L, "Скаков Баур", "333", "b@mail.ru",
                        ContactStatus.CONTACT_NEW,
                        clientRepository.getById(1L)),
                new Contact(3L, "Утепова Алия", "111", "c@mail.ru",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(1L)),
                new Contact(4L, "Иванов Иван", "3232", "d@mail.ru",
                        ContactStatus.CONTACT_ARCHIVE,
                        clientRepository.getById(2L)),
                new Contact(5L, "Петров Петя", "45234", "e@mail.ru",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(2L)),
                new Contact(6L, "Гоги", "343", "x@mail.ru",
                        ContactStatus.CONTACT_NEW,
                        clientRepository.getById(2L)),
                new Contact(7L, "Зеленая Ольга", "543", "a2@mail.ru",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(3L)),
                new Contact(8L, "Синяя Хельга", "324", "a4@mail.ru",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(4L)),
                new Contact(9L, "Желтая Анна", "543", "a8@mail.ru",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(5L))
        };
    }

    private Product[] products() {
        List<Product> product = productRepository.findAll();
        return new Product[]{
                new Product(1,
                        "ВТУЛКА КОЛЕНВАЛА",
                        10,
                        new BigDecimal(3312),
                        new BigDecimal(5378.7),
                        true),
                new Product(2,
                        "Втулка коленчатого вала без шпон. паза 406.1005038-11 100504",
                        10,
                        new BigDecimal(1580),
                        new BigDecimal(2565.92),
                        true),
                new Product(3,
                        "Адаптер для дрели М14",
                        10,
                        new BigDecimal(406),
                        new BigDecimal(659.34),
                        true),
                new Product(4,
                        "Масло Газпромнефть Супер 10W40 SG/CD 5л.",
                        10,
                        new BigDecimal(4679),
                        new BigDecimal(7598.7),
                        true),
                new Product(5,
                        "ET-912-YE",
                        10,
                        new BigDecimal(173),
                        new BigDecimal(280.95),
                        true)
        };
    }

    private Order[] orders() {
        return new Order[]{
                new Order(1L, LocalDateTime.now().minusDays(15),
                        clientRepository.getById(1L)),
                new Order(2L, LocalDateTime.now().minusDays(13),
                        clientRepository.getById(1L)),
                new Order(3L, LocalDateTime.now().minusDays(10),
                        clientRepository.getById(2L)),
        };
    }

    private OrderProducts[] ordersProducts() {
        return new OrderProducts[]{
                new OrderProducts(1L,
                        orderRepository.getById(1L),
                        productRepository.getById(1), 10),
                new OrderProducts(2L,
                        orderRepository.getById(1L),
                        productRepository.getById(2), 2),
                new OrderProducts(3L,
                        orderRepository.getById(1L),
                        productRepository.getById(3), 1),
                new OrderProducts(4L,
                        orderRepository.getById(1L),
                        productRepository.getById(4), 1),
                new OrderProducts(5L,
                        orderRepository.getById(1L),
                        productRepository.getById(5), 3),
                // next order
                new OrderProducts(6L,
                        orderRepository.getById(2L),
                        productRepository.getById(1), 1),
                new OrderProducts(7L,
                        orderRepository.getById(2L),
                        productRepository.getById(2), 5)
        };
    }

    private Client[] clients() {
        return new Client[]{
                new Client(1L,
                        "Тест клиент 1 новый",
                        "ск ном 1",
                        "Almaty",
                        "777",
                        "test1@gmail.com",
                        ClientStatus.CLIENT_NEW),
                new Client(2L,
                        "Тест клиент 2 постоянный",
                        "ск ном 2",
                        "Boston",
                        "555",
                        "test2@gmail.com",
                        ClientStatus.CLIENT_CONSTANT),
                new Client(3L,
                        "Тест клиент 3 новый",
                        "ск ном 3",
                        "Shymkent",
                        "888",
                        "test3@gmail.com",
                        ClientStatus.CLIENT_NEW),
                new Client(4L,
                        "Тест клиент 4 новый",
                        "ск ном 4",
                        "Saint-Peterburg",
                        "999",
                        "test4@gmail.com",
                        ClientStatus.CLIENT_NEW),
                new Client(5L,
                        "Тест клиент 5 постоянный",
                        "ск ном 5",
                        "Nur-Sultan",
                        "444",
                        "test5@gmail.com",
                        ClientStatus.CLIENT_CONSTANT)
        };
    }

    private Supplier[] suppliers() {
        return new Supplier[]{
                new Supplier(1L,
                        "Company",
                        "Тестов Тест Тестович",
                        "test@mail.ru",
                        "14"),
                new Supplier(2L,
                        "Company2",
                        "Поставщик Поставкович",
                        "supply@mail.ru",
                        "30"),
                new Supplier(3L,
                        "Company3",
                        "Peter Parker",
                        "spiderman@mail.ru",
                        "7"),
                new Supplier(4L,
                        "Company4",
                        "Naruto Uzumaki",
                        "saske@mail.ru",
                        "8")

        };
    }
}
