package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ContactDto;
import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.ClientStatus;
import kz.attractor.datamodel.model.Contact;
import kz.attractor.datamodel.model.ContactStatus;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.datamodel.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;

    public List<ContactDto> findByClientId(long id) {
        var contacts = contactRepository.findAllByClient_Id(id)
                .stream()
                .map(ContactDto::from)
                .collect(Collectors.toList());
        return contacts;
    }

    public ContactDto findById(long id) {
        var contact = contactRepository.findById(id).orElse(null);
        return ContactDto.from(contact);
    }

    public ContactDto update(ContactDto form) {
        var contactOpt = contactRepository.findById(form.getId());
        if (contactOpt.isEmpty()) {
            return null;
        }
        Contact contact = Contact.builder()
                .id(form.getId())
                .name(form.getName())
                .phone(form.getPhone())
                .email(form.getEmail())
                .status(ContactStatus.valueOfLabel(form.getStatus()))
                .client(clientRepository.findById(form.getId()).get())
                .build();
        return ContactDto.from(contactRepository.save(contact));
    }
}
