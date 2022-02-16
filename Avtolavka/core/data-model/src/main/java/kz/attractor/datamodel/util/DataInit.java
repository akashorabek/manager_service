package kz.attractor.datamodel.util;

import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.ClientStatus;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.datamodel.repository.ClientStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Stream;

@Configuration
@AllArgsConstructor
public class DataInit {
    private final ClientStatusRepository clientStatusRepository;
    private final ClientRepository clientRepository;

    @Bean
    public CommandLineRunner init() {
        try {
            initClientStatuses().run();
            initClients().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private CommandLineRunner initClientStatuses() {
        return (args) -> Stream.of(clientStatuses())
                .peek(System.out::println)
                .forEach(clientStatusRepository::save);
    }

    private ClientStatus[] clientStatuses() {
        return new ClientStatus[]{
                new ClientStatus(1L, "Новый"),
                new ClientStatus(2L, "Постоянный")
        };
    }

    private CommandLineRunner initClients() {
        return (args) -> Stream.of(clients())
                .peek(System.out::println)
                .forEach(clientRepository::save);
    }

    private Client[] clients() {
        List<ClientStatus> statuses = clientStatusRepository.findAll();
        return new Client[]{
                new Client(1L,
                        "Тест клиент новый",
                        "ск ном 1",
                        "Almaty",
                        "777",
                        "test1@gmail.com",
                        statuses.get(0)),
                new Client(2L,
                        "Тест клиент постоянный",
                        "ск ном 2",
                        "Boston",
                        "555",
                        "test2@gmail.com",
                        statuses.get(1)),
                new Client(3L,
                        "Тест клиент новый",
                        "ск ном 3",
                        "Shymkent",
                        "888",
                        "test3@gmail.com",
                        statuses.get(0)),
                new Client(4L,
                        "Тест клиент новый",
                        "ск ном 4",
                        "Saint-Peterburg",
                        "999",
                        "test4@gmail.com",
                        statuses.get(0)),
                new Client(5L,
                        "Тест клиент новый",
                        "ск ном 5",
                        "Nur-Sultan",
                        "444",
                        "test5@gmail.com",
                        statuses.get(0))
        };
    }
}
