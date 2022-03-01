package kz.attractor.api.dto;

import kz.attractor.datamodel.model.ClientBank;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientDtoAdd {
    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым")
    private String accountNumber;

    @NotBlank(message = "Поле не должно быть пустым")
    private String address;

    @NotBlank(message = "Поле не должно быть пустым")
    private String phone;

    @NotBlank(message = "Поле не должно быть пустым")
    @Email(message = "В поле должен находиться email")
    private String email;

    @NotNull(message = "Поле не должно быть пустым")
    private ClientBank bank;
}
