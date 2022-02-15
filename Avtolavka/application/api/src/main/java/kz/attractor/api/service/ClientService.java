package kz.attractor.api.service;

import datamodel.datamodel.model.Client;
import datamodel.datamodel.repository.ClientRepository;
import kz.attractor.api.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientDto::from)
                .collect(Collectors.toList());
    }
}
