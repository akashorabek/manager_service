package kz.attractor.api.service;

import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.api.dto.ClientDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientDto::from)
                .collect(Collectors.toList());
    }
}
