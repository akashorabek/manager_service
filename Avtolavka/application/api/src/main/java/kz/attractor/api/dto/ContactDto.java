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
    private String phone1;
    private String phone2;
    private String phone3;
    private String email1;
    private String email2;
    private String email3;
    private String position;
    private String status;
    private long clientId;

    public static ContactDto from (Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .phone1(contact.getPhone1())
                .phone2(contact.getPhone1())
                .phone3(contact.getPhone3())
                .email1(contact.getEmail1())
                .email2(contact.getEmail2())
                .email3(contact.getEmail3())
                .position(contact.getPosition())
                .status(contact.getStatus().label)
                .clientId(contact.getClient().getId())
                .build();
    }
}
