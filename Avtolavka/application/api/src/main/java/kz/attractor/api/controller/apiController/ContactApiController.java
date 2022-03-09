package kz.attractor.api.controller.apiController;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ContactDto;
import kz.attractor.api.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactApiController {
    private final ContactService contactService;

    @GetMapping("/api/contacts/{id}")
    public ContactDto getContact(@PathVariable long id) {
        var contact = contactService.findById(id);
        return contact;
    }

    @GetMapping("/api/contacts/search")
    public List<ContactDto> getClients(@RequestParam String query) {
        return contactService.findAllSearched(query);
    }
}
