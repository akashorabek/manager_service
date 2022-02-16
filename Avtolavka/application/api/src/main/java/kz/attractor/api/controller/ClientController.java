package kz.attractor.api.controller;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")
    public String showClientsPage(Model model) {
        //List<ClientDto> clients = clientService.findAll();
        //model.addAttribute("clients", clients);
        return "clients";
    }
}
