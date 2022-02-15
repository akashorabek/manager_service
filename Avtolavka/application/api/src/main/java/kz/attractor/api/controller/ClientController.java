package kz.attractor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ClientController {

    @GetMapping("/clients")
    public String showClientsPage() {
        return "clients";
    }
}
