package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.ClientStatus;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.api.dto.ClientDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public ClientDto findById(long id) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        ClientDto client = null;
        if (clientOpt.isPresent()) {
            client = ClientDto.from(clientOpt.get());
        }
        return client;
    }

    public ClientDto editClient(ClientDto form) {
        Optional<Client> clientOpt = clientRepository.findById(form.getId());
        if (clientOpt.isEmpty()) {
            return null;
        }
        Client client = Client.builder()
                .id(form.getId())
                .name(form.getName())
                .accountNumber(form.getAccountNumber())
                .address(form.getAddress())
                .phone(form.getPhone())
                .email(form.getEmail())
                .status(ClientStatus.valueOfLabel(form.getStatus()))
                .build();
        return ClientDto.from(clientRepository.save(client));
    }

    public void addClient(ClientDtoAdd form) {
        Client client = Client.builder()
                .name(form.getName())
                .accountNumber(form.getAccountNumber())
                .address(form.getAddress())
                .phone(form.getPhone())
                .email(form.getEmail())
                .status(ClientStatus.CLIENT_NEW)
                .build();
        clientRepository.save(client);
    }
}
