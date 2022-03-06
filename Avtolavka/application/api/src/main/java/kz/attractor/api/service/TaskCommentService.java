package kz.attractor.api.service;

import kz.attractor.api.dto.TaskCommentDto;
import kz.attractor.api.dto.TaskCommentDtoAdd;
import kz.attractor.api.exception.ObjectDontExistException;
import kz.attractor.datamodel.model.TaskComment;
import kz.attractor.datamodel.repository.TaskCommentRepository;
import kz.attractor.datamodel.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskCommentService {

    private final TaskCommentRepository taskCommentRepository;
    public final TaskRepository taskRepository;

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

    public List<TaskCommentDto> findAllByTask_Id(long id) {
        var comments = taskCommentRepository.findAllByTask_Id(id)
                .stream()
                .map(TaskCommentDto::from)
                .collect(Collectors.toList());
        comments.sort(Comparator.comparing(TaskCommentDto::getCreateDate).reversed());
        return comments;
    }

    public TaskCommentDto findById(long id) {
        var comment = taskCommentRepository.findById(id).orElseThrow( () ->
                new ObjectDontExistException("Задача с id " + id + " отсутствует"));
        return TaskCommentDto.from(comment);
    }

    public void add(TaskCommentDtoAdd dto){
        TaskComment taskComment = TaskComment.builder()
                .description(dto.getDescription())
                .createDate(LocalDate.now().toString())
                .task(taskRepository.getById(dto.getTaskId()))
                .build();
        taskCommentRepository.save(taskComment);
    }
}
