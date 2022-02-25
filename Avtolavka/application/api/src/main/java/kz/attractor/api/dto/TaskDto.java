package kz.attractor.api.dto;


import kz.attractor.datamodel.model.Task;
import kz.attractor.datamodel.model.TaskStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TaskDto {

    private Long id;

    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым")
    private String description;

    @NotBlank(message = "Поле не должно быть пустым")
    private LocalDate create;

    @NotBlank(message = "Поле не должно быть пустым")
    private LocalDate deadline;


    private LocalDate finish;

    private TaskStatus status;

    public static TaskDto from(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .create(task.getCreate())
                .deadline(task.getDeadline())
                .finish(task.getFinish())
                .status(task.getStatus())
                .build();
    }
}
