package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.ClientStatus;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.api.dto.ClientDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientDto> findAll() {
        var clients = clientRepository.findAll()
                .stream()
                .map(ClientDto::from)
                .collect(Collectors.toList());
        clients.sort(Comparator.comparing(ClientDto::getStatus).reversed());
        return clients;
    }

    public ClientDto findById(long id) {
        var client = clientRepository.findById(id).orElse(null);
        return ClientDto.from(client);
    }

    public ClientDto update(ClientDto form) {
        var clientOpt = clientRepository.findById(form.getId());
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

    public void add(ClientDtoAdd form) {
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
