package kz.attractor.api.service;

import datamodel.datamodel.model.Client;
import datamodel.datamodel.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public void findAll() {
        List<Client> all = clientRepository.findAll();
    }
}
