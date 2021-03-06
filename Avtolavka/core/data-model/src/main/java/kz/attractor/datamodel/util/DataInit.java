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
    private final OrderProductRepository orderProductRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductNameRepository productNameRepository;

    @Bean
    public CommandLineRunner init() {
        try {
            initClients().run();
            initContacts().run();
            initSuppliers().run();
            initWarehouses().run();
            initProductNames().run();
            initProducts().run();
            initOrders().run();
            initOrdersProducts().run();
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
    private CommandLineRunner initProductNames() {
        return (args -> Stream.of(productNames())
                .peek(System.out::println)
                .forEach(productNameRepository::save));
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
                .forEach(orderProductRepository::save);
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
                new Contact(1L, "Рыжова Оксана",
                        "222",
                        "111",
                        null,
                        "a@mail.ru",
                        null,
                        null,
                        "purchase manager",
                        ContactStatus.CONTACT_ARCHIVE,
                        clientRepository.getById(1L)),
                new Contact(2L, "Скаков Баур",
                        "333",
                        "1345",
                        null,
                        "b@mail.ru",
                        null,
                        null,
                        "logistics manager",
                        ContactStatus.CONTACT_NEW,
                        clientRepository.getById(1L)),
                new Contact(3L, "Утепова Алия",
                        "111",
                        "6549433",
                        null,
                        "c@mail.ru",
                        null,
                        null,
                        "contract manager",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(1L)),
                new Contact(4L, "Иванов Иван",
                        "3232",
                        null,
                        null,
                        "d@mail.ru",
                        null,
                        null,
                        "механик",
                        ContactStatus.CONTACT_ARCHIVE,
                        clientRepository.getById(2L)),
                new Contact(5L, "Петров Петя",
                        "45234",
                        null,
                        null,
                        "e@mail.ru",
                        null,
                        null,
                        "закупщик",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(2L)),
                new Contact(6L, "Гоги",
                        "343",
                        "123546",
                        null,
                        "x@mail.ru",
                        "mail@ru",
                        null,
                        "офис-менеджер",
                        ContactStatus.CONTACT_NEW,
                        clientRepository.getById(2L)),
                new Contact(7L, "Зеленая Ольга",
                        "543",
                        null,
                        null,
                        "a2@mail.ru",
                        "asdasdasd.@ru",
                        null,
                        "purchase manager",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(3L)),
                new Contact(8L, "Синяя Хельга",
                        "324",
                        "123",
                        "89446465",
                        "a4@mail.ru",
                        null,
                        null,
                        "логист",
                        ContactStatus.CONTACT_CONSTANT,
                        clientRepository.getById(4L)),
                new Contact(9L, "Желтая Анна",
                        "543",
                        "879846513",
                        "651348",
                        "a8@mail.ru",
                        null,
                        null,
                        "операционный manager",
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
                        true,
                        "втулка коленвал",
                        warehouseRepository.getById(1L),
                        productNameRepository.getById(1L)),

                new Product(2,
                        "Втулка коленчатого вала без шпон. паза 406.1005038-11 100504",
                        10,
                        new BigDecimal(1580),
                        new BigDecimal(2565.92),
                        false,
                        "втулка вал шпон 406.1005038-11 100504 1005038 11 паз",
                        warehouseRepository.getById(3L),
                        productNameRepository.getById(2L)),
                new Product(3,
                        "Адаптер для дрели М14",
                        10,
                        new BigDecimal(406),
                        new BigDecimal(659.34),
                        true,
                        "даптер дрель М14 м14",
                        warehouseRepository.getById(2L),
                        productNameRepository.getById(3L)),
                new Product(4,
                        "Масло Газпромнефть Супер 10W40 SG/CD 5л.",
                        10,
                        new BigDecimal(4679),
                        new BigDecimal(7598.7),
                        false,
                        "масло газпром нефть супер 10W40 10 SG ",
                        warehouseRepository.getById(2L),
                        productNameRepository.getById(4L)),
                new Product(5,
                        "ET-912-YE",
                        10,
                        new BigDecimal(173),
                        new BigDecimal(280.95),
                        true,
                        "ET 912 YE",
                        warehouseRepository.getById(3L),
                        productNameRepository.getById(5L))
        };
    }

    private Order[] orders() {
        return new Order[]{
                new Order(1L, LocalDateTime.now().minusDays(15),
                        contactRepository.getById(1L), false),
                new Order(2L, LocalDateTime.now().minusDays(13),
                        contactRepository.getById(1L), false),
                new Order(3L, LocalDateTime.now().minusDays(10),
                        contactRepository.getById(2L), true),
        };
    }

    private OrderProduct[] ordersProducts() {
        return new OrderProduct[]{
                new OrderProduct(1L,
                        orderRepository.getById(1L),
                        productRepository.getById(1), 10),
                new OrderProduct(2L,
                        orderRepository.getById(1L),
                        productRepository.getById(2), 2),
                new OrderProduct(3L,
                        orderRepository.getById(1L),
                        productRepository.getById(3), 1),
                new OrderProduct(4L,
                        orderRepository.getById(1L),
                        productRepository.getById(4), 1),
                new OrderProduct(5L,
                        orderRepository.getById(1L),
                        productRepository.getById(5), 3),
                // next order
                new OrderProduct(6L,
                        orderRepository.getById(2L),
                        productRepository.getById(1), 1),
                new OrderProduct(7L,
                        orderRepository.getById(2L),
                        productRepository.getById(2), 5)
        };
    }

    private Client[] clients() {
        return new Client[]{
                new Client(1L,
                        "Тест клиент 1 новый",
                        "Тест клиент 1 краткое название",
                        "ск ном 1",
                        "Almaty",
                        "777", "777", "111", "222",
                        "test1@gmail.com", "test1@gmail.com", "test2@gmail.com", "test3@gmail.com",
                        ClientStatus.CLIENT_NEW,
                        ClientBank.ALFA_BANK),
                new Client(2L,
                        "Тест клиент 2 постоянный",
                        "Краткое название 2 клиента",
                        "ск ном 2",
                        "Boston",
                        "777", "777", "111", "222",
                        "test1@gmail.com", "test1@gmail.com", "test2@gmail.com", "test3@gmail.com",
                        ClientStatus.CLIENT_CONSTANT,
                        ClientBank.HALYK_BANK),
                new Client(3L,
                        "Тест клиент 3 новый",
                        "Тест клиент 3 новый",
                        "ск ном 3",
                        "Shymkent",
                        "777", "777", "111", "222",
                        "test1@gmail.com", "test1@gmail.com", "test2@gmail.com", "test3@gmail.com",
                        ClientStatus.CLIENT_NEW,
                        ClientBank.KASPI_BANK),
                new Client(4L,
                        "Тест клиент 4 новый",
                        "короткое название 4 клиента",
                        "ск ном 4",
                        "Saint-Peterburg",
                        "777", "777", "111", "222",
                        "test1@gmail.com", "test1@gmail.com", "test2@gmail.com", "test3@gmail.com",
                        ClientStatus.CLIENT_NEW,
                        ClientBank.HOME_CREDIT_BANK),
                new Client(5L,
                        "Тест клиент 5 постоянный",
                        "Пятый клиент",
                        "ск ном 5",
                        "Nur-Sultan",
                        "777", "777", "111", "222",
                        "test1@gmail.com", "test1@gmail.com", "test2@gmail.com", "test3@gmail.com",
                        ClientStatus.CLIENT_CONSTANT,
                        ClientBank.SBERBANK)
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

    private ProductName[] productNames(){
        return new ProductName[]{
                new ProductName(1L,
                        "ВТУЛКА КОЛЕНВАЛА ГАЗ 3240" ),
                new ProductName(2L,
                        "Втулка коленчатого вала без шпон"),
                new ProductName(3L,
                        "Адаптер для дрели М14" ),
                new ProductName(4L,
                        "Масло Газпромнефть Супер 5л."  ),
                new ProductName(5L,
                        "ET-912" )
        };

    }
}
