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
    private String accountNumber;

    @NotBlank(message = "Поле не должно быть пустым")
    private String address;

    @NotBlank(message = "Поле не должно быть пустым")
    private String phone;

    @NotBlank(message = "Поле не должно быть пустым")
    private String email;

    private String status;

    private ClientBank bank;

    public static ClientDto from(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .accountNumber(client.getAccountNumber())
                .address(client.getAddress())
                .phone(client.getPhone())
                .email(client.getEmail())
                .status(client.getStatus().label)
                .bank(client.getBank())
                .build();
    }
}
