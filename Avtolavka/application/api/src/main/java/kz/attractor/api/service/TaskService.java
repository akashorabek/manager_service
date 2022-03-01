package kz.attractor.api.service;

import kz.attractor.api.dto.TaskDto;
import kz.attractor.datamodel.model.Task;
import kz.attractor.datamodel.model.TaskStatus;
import kz.attractor.datamodel.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {


    private final TaskRepository repository;

    public List<TaskDto> findAll(){
     var tasks = repository.findAll()
             .stream()
             .map(TaskDto::from)
             .collect(Collectors.toList());
        tasks.sort(Comparator.comparing(TaskDto::getCreate).reversed());
        return tasks;
    }

    public TaskDto findById(long id) {
        var task = repository.findById(id).orElse(null);
        return TaskDto.from(task);
    }

    public TaskDto update(TaskDto dto){
        var taskOptional = repository.findById(dto.getId());
        if (taskOptional.isEmpty()){
            return null;
        }
        Task task = Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .create(dto.getCreate())
                .deadline(dto.getDeadline())
                .status(TaskStatus.valueOfLabel(dto.getStatus()))
                .finish(dto.getFinish())
                .build();
        return TaskDto.from(repository.save(task));
    }

    public void add(TaskDto dto){
        Task task = Task.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .create(LocalDate.now())
                .deadline(dto.getDeadline())
                .status(TaskStatus.TASK_NEW)
                .build();
        repository.save(task);
    }

}
