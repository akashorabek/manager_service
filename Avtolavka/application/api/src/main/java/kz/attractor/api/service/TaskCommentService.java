package kz.attractor.api.service;

import kz.attractor.api.dto.TaskCommentDto;
import kz.attractor.api.dto.TaskCommentDtoAdd;
import kz.attractor.datamodel.model.TaskComment;
import kz.attractor.datamodel.repository.TaskCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskCommentService {

    private final TaskCommentRepository taskCommentRepository;

    public Page<TaskCommentDto> findAll(Pageable pageable) {
        Page<TaskComment> taskComments = taskCommentRepository.findAll(pageable);
        return new PageImpl<TaskCommentDto>(
                taskComments.getContent().stream()
                        .map(TaskCommentDto::from)
                        .sorted(Comparator.comparing(TaskCommentDto::getCreateDate).reversed())
                        .collect(Collectors.toList()),
                pageable, taskComments.getTotalElements()
        );
    }

    public void add(TaskCommentDtoAdd dto){
        TaskComment taskComment = TaskComment.builder()
                .description(dto.getDescription())
                .createDate(LocalDate.now().toString())
                .build();
        taskCommentRepository.save(taskComment);
    }
}
