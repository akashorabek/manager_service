package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ContactDto;
import kz.attractor.datamodel.model.Contact;
import kz.attractor.datamodel.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public List<Contact> findByClientId(long id) {
        var contacts = contactRepository.findAllByClient_Id(id);
        var contactsDto = contacts;

        return contacts;
    }
}
