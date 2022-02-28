package kz.attractor.api.controller.apiController;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientApiController {
    private final ClientService service;

    @GetMapping("/api/clients")
    public List<ClientDto> getClients(@RequestParam String query) {
        return service.findAllSearched(query);
    }
}
