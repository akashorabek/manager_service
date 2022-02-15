package datamodel.datamodel.util;

import datamodel.datamodel.model.ClientStatus;
import datamodel.datamodel.repository.ClientRepository;
import datamodel.datamodel.repository.ClientStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
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
}
