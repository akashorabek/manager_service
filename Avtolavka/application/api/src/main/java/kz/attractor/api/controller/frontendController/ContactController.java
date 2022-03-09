package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.ContactDto;
import kz.attractor.api.dto.ContactDtoAdd;
import kz.attractor.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/contacts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        ContactDto contact = contactService.findById(id);
        model.addAttribute("form", contact);
        return "contact-edit";
    }

    @PostMapping("contact-edit")
    public String edit(ContactDto form) {
        contactService.update(form);
        return "redirect:/clients/" + form.getClientId();
    }

    @GetMapping("/clients/{id}/contacts/add")
    public String add(@PathVariable long id, Model model) {
        model.addAttribute("clientId", id);
        return "contact-add";
    }

    @PostMapping("contact-add")
    public String add(ContactDtoAdd form) {
        contactService.add(form);
        return "redirect:/clients/" + form.getClientId();
    }
}
