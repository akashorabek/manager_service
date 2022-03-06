package kz.attractor.api.dto;


import kz.attractor.datamodel.model.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TaskDto{

    private Long id;

    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым")
    private String description;

    @NotBlank(message = "Поле не должно быть пустым")
    private String createDate;

    @NotBlank(message = "Поле не должно быть пустым")
    private String deadline;


    private LocalDate finish;

    private String status;

    private String comment;

    public static TaskDto from(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .createDate(task.getCreateDate())
                .deadline(task.getDeadline())
                .finish(task.getFinish())
                .status(task.getStatus().label)
                .comment(task.getComment().getDescription())
                .build();
    }
}
