package kz.attractor.api.dto;

import kz.attractor.datamodel.model.ClientBank;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientDtoAdd {
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

    @NotNull(message = "Поле не должно быть пустым")
    private ClientBank bank;
}
