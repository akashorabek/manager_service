package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.api.dto.OrderDto;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.ClientSpecification;
import kz.attractor.datamodel.model.ClientStatus;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.api.dto.ClientDto;

import kz.attractor.datamodel.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return new PageImpl<ClientDto>(
                clients.getContent().stream()
                        .map(ClientDto::from)
                        .sorted(Comparator.comparing(ClientDto::getStatus).reversed())
                        .collect(Collectors.toList()),
                pageable, clients.getTotalElements()
        );
    }

    public List<ClientDto> findAll() {
        var clients = clientRepository.findAll()
                .stream()
                .map(ClientDto::from)
                .collect(Collectors.toList());
        clients.sort(Comparator.comparing(ClientDto::getStatus).reversed());
        return clients;
    }

    public List<ClientDto> findAllSearched(String query) {
        ClientSpecification nameLike = new ClientSpecification(new SearchCriteria("name", ":", query));
        var clients = clientRepository.findAll(nameLike)
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
