package kz.attractor.api.dto;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class TaskDtoAdd {

    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым")
    private String description;

    @NotBlank(message = "Поле не должно быть пустым")
    private String deadline;
}
