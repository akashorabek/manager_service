package kz.attractor.api.dto;

import kz.attractor.datamodel.model.TaskComment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class TaskCommentDto {

    private Long id;

    @NotBlank(message = "Поле не должно быть пустым")
    private String description;

    @NotBlank(message = "Поле не должно быть пустым")
    private String createDate;

    public static TaskCommentDto from (TaskComment taskComment){
        return TaskCommentDto.builder()
                .id(taskComment.getId())
                .description(taskComment.getDescription())
                .createDate(taskComment.getCreateDate())
                .build();
    }
}
