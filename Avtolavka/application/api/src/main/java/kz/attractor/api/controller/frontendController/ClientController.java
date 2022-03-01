package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.api.dto.ContactDto;
import kz.attractor.api.service.ClientService;
import kz.attractor.api.service.ContactService;
import kz.attractor.datamodel.model.ClientBank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ContactService contactService;

    @GetMapping("/clients")
    public String showClients(Model model,
                              @PageableDefault(sort = {"status"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
        Page<ClientDto> clients = clientService.findAll(pageable);
        model.addAttribute("page", clients);
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String showClient(@PathVariable long id, Model model) {
        ClientDto client = clientService.findById(id);
        model.addAttribute("client", client);
        List<ContactDto> contacts = contactService.findByClientId(client.getId());
        model.addAttribute("contacts", contacts);
        return "client";
    }

    @GetMapping("/clients/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        ClientDto client = clientService.findById(id);
        model.addAttribute("form", client);
        return "client-edit";
    }

    @PostMapping("client-edit")
    public String edit(@Valid ClientDto form,
                             BindingResult validationResult,
                             RedirectAttributes attributes) {
        attributes.addFlashAttribute("form", form);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/clients/" + form.getId() + "/edit";
        }
        clientService.update(form);
        return "redirect:/clients/" + form.getId();
    }

    @GetMapping("/clients/add")
    public String add(Model model) {
        model.addAttribute("banks", ClientBank.values());
        return "client-add";
    }

    @PostMapping("client-add")
    public String add(@Valid ClientDtoAdd form,
                            BindingResult validationResult,
                            RedirectAttributes attributes) {
        attributes.addFlashAttribute("form", form);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/clients/add";
        }
        clientService.add(form);
        return "redirect:/clients";
    }
}
