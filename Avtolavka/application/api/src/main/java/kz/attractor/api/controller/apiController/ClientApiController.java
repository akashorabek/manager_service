package kz.attractor.api.controller.apiController;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientApiController {
    private final ClientService clientService;

    @GetMapping("/api/clients/search")
    public List<ClientDto> getClients(@RequestParam String query) {

        return clientService.findAllSearched(query);
    }

    @GetMapping("/api/clients")
    public Page<ClientDto> findClients(@PageableDefault(sort = {"status"}, direction = Sort.Direction.DESC, size = 3)
                                               Pageable pageable) {
        Page<ClientDto> clients = clientService.findAll(pageable);
        return clients;
    }

    @GetMapping("/api/clients/{id}")
    public ClientDto getClient(@PathVariable long id) {
        var client = clientService.findById(id);
        return client;
    }

    @PostMapping("/api/clients/add")
    public ClientDto add(ClientDtoAdd form) {
        return clientService.add(form);
    }
}
