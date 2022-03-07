package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.api.exception.ObjectDontExistException;
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
        var client = clientRepository.findById(id).orElseThrow( () ->
                new ObjectDontExistException("Клиент с id " + id + " отсутствует"));
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
                .shortName(form.getShortName())
                .accountNumber(form.getAccountNumber())
                .address(form.getAddress())
                .phoneMain(form.getPhoneMain())
                .phone1(form.getPhone1())
                .phone2(form.getPhone2())
                .phone3(form.getPhone3())
                .emailMain(form.getEmailMain())
                .email1(form.getEmail1())
                .email2(form.getEmail2())
                .email3(form.getEmail3())
                .status(ClientStatus.valueOfLabel(form.getStatus()))
                .bank(form.getBank())
                .build();
        return ClientDto.from(clientRepository.save(client));
    }

    public void add(ClientDtoAdd form) {
        Client client = Client.builder()
                .name(form.getName())
                .shortName(form.getShortName())
                .accountNumber(form.getAccountNumber())
                .address(form.getAddress())
                .phoneMain(form.getPhoneMain())
                .emailMain(form.getEmailMain())
                .status(ClientStatus.CLIENT_NEW)
                .bank(form.getBank())
                .build();
        clientRepository.save(client);
    }
}
