package kz.attractor.api.service;

import kz.attractor.api.dto.ClientDto;
import kz.attractor.api.dto.ContactDto;
import kz.attractor.api.dto.ContactDtoAdd;
import kz.attractor.api.exception.ObjectDontExistException;
import kz.attractor.datamodel.model.ClientSpecification;
import kz.attractor.datamodel.model.Contact;
import kz.attractor.datamodel.model.ContactSpecification;
import kz.attractor.datamodel.model.ContactStatus;
import kz.attractor.datamodel.repository.ClientRepository;
import kz.attractor.datamodel.repository.ContactRepository;
import kz.attractor.datamodel.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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
        contacts.sort(Comparator.comparing(ContactDto::getStatus).reversed());
        return contacts;
    }

    public ContactDto findById(long id) {
        var contact = contactRepository.findById(id).orElseThrow( () ->
                new ObjectDontExistException("Контактное лицо с id " + id + " отсутствует"));
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
                .phone1(form.getPhone1())
                .phone2(form.getPhone2())
                .phone3(form.getPhone3())
                .email1(form.getEmail1())
                .email2(form.getEmail2())
                .email3(form.getEmail3())
                .position(form.getPosition())
                .status(ContactStatus.valueOfLabel(form.getStatus()))
                .client(clientRepository.findById(form.getClientId()).get())
                .build();
        return ContactDto.from(contactRepository.save(contact));
    }

    public void add(ContactDtoAdd form) {
        Contact contact = Contact.builder()
                .name(form.getName())
                .phone1(form.getPhone1())
                .phone2(form.getPhone2())
                .phone3(form.getPhone3())
                .email1(form.getEmail1())
                .email2(form.getEmail2())
                .email3(form.getEmail3())
                .position(form.getPosition())
                .status(ContactStatus.CONTACT_NEW)
                .client(clientRepository.findById(form.getClientId()).get())
                .build();
        contactRepository.save(contact);
    }

    public List<ContactDto> findAllSearched(String query) {
        ContactSpecification nameLike = new ContactSpecification(new SearchCriteria("name", ":", query));
        var contacts = contactRepository.findAll(nameLike)
                .stream()
                .map(ContactDto::from)
                .collect(Collectors.toList());
        contacts.sort(Comparator.comparing(ContactDto::getStatus).reversed());
        return contacts;
    }
}
