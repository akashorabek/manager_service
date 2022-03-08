package kz.attractor.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDtoAdd {
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
}
