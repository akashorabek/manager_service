package kz.attractor.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDtoAdd {
    private String name;
    private String shortName;
    private String accountNumber;
    private String address;
    private String phoneMain;
    private String phone1;
    private String phone2;
    private String phone3;
    private String emailMain;
    private String email1;
    private String email2;
    private String email3;
    private String bank;
}
