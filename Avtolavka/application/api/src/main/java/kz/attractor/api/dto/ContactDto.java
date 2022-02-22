package kz.attractor.api.dto;

import kz.attractor.datamodel.model.Contact;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDto {
    private long id;
    private String name;
    private String phone;
    private String email;
    private String status;
    private long clientId;

    public static ContactDto from (Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .status(contact.getStatus().label)
                .clientId(contact.getClient().getId())
                .build();
    }
}
