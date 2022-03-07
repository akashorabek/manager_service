package kz.attractor.api.dto;

import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.ClientBank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class ClientDto {
    private long id;

    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым")
    private String shortName;

    @NotBlank(message = "Поле не должно быть пустым")
    private String accountNumber;

    @NotBlank(message = "Поле не должно быть пустым")
    private String address;

    private String phoneMain;
    private String phone1;
    private String phone2;
    private String phone3;
    private String emailMain;
    private String email1;
    private String email2;
    private String email3;
    private String status;
    private ClientBank bank;

    public static ClientDto from(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .shortName(client.getShortName())
                .accountNumber(client.getAccountNumber())
                .address(client.getAddress())
                .phoneMain(client.getPhoneMain())
                .phone1(client.getPhone1())
                .phone2(client.getPhone2())
                .phone3(client.getPhone3())
                .emailMain(client.getEmailMain())
                .email1(client.getEmail1())
                .email2(client.getEmail2())
                .email3(client.getEmail3())
                .status(client.getStatus().label)
                .bank(client.getBank())
                .build();
    }
}
