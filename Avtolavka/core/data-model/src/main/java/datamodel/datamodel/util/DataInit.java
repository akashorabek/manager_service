package datamodel.datamodel.util;

import datamodel.datamodel.model.Client;
import datamodel.datamodel.model.ClientStatus;
import datamodel.datamodel.repository.ClientRepository;
import datamodel.datamodel.repository.ClientStatusRepository;
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
                new ClientStatus(1, "Новый"),
                new ClientStatus(2, "Постоянный")
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
                new Client(1,
                        "Тест клиент новый",
                        "ск ном 1",
                        "Almaty",
                        "777",
                        "test1@gmail.com",
                        statuses.get(0)),
                new Client(2,
                        "Тест клиент постоянный",
                        "ск ном 2",
                        "Boston",
                        "555",
                        "test2@gmail.com",
                        statuses.get(1))
        };
    }
}
