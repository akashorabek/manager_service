package kz.attractor.api.dto;

import kz.attractor.datamodel.model.Contact;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String status;
    private String client;

    public static ContactDto from (Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .status(contact.getStatus().label)
                .client(contact.getClient().getName())
                .build();
    }
}
