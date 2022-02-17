package kz.attractor.api.dto;

import kz.attractor.datamodel.model.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDto {
    private long id;
    private String name;
    private String accountNumber;
    private String address;
    private String phone;
    private String email;
    private String status;

    public static ClientDto from(Client client) {
       return ClientDto.builder()
               .id(client.getId())
              .name(client.getName())
              .accountNumber(client.getAccountNumber())
              .address(client.getAddress())
              .phone(client.getPhone())
               .email(client.getEmail())
              .status(client.getStatus().getStatus())
             .build();
    }
}
