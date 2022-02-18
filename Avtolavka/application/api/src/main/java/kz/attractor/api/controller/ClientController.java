package kz.attractor.api.controller;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")
    public String showClientsPage(Model model) {
        List<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String showClientPage(@PathVariable long id, Model model) {
        ClientDto client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client";
    }

    @GetMapping("/clients/{id}/edit")
    public String showClientEditPage(@PathVariable long id, Model model) {
        ClientDto client = clientService.findById(id);
        model.addAttribute("form", client);
        return "client-edit";
    }

    @PostMapping("client-edit")
    public String editClient(@Valid ClientDto form,
                             BindingResult validationResult,
                             RedirectAttributes attributes) {
        attributes.addFlashAttribute("form", form);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/clients/" + form.getId() + "/edit";
        }
        clientService.editClient(form);
        return "redirect:/clients/" + form.getId();
    }

    @GetMapping("/clients/add")
    public String addClient() {
        return "client-add";
    }

    @PostMapping("client-add")
    public String addClient(@Valid ClientDtoAdd form,
                            BindingResult validationResult,
                            RedirectAttributes attributes) {
        attributes.addFlashAttribute("form", form);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/clients/add";
        }
        clientService.addClient(form);
        return "redirect:/clients";
    }
}
