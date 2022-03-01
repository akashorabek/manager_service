package kz.attractor.scheduler_service;

import kz.attractor.datamodel.model.Task;
import kz.attractor.datamodel.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskSchedulerService {

    private final TaskRepository taskRepository;

    @Scheduled(cron = "0 0 * * ?")
    public void remove(){
        String status = "Завершена";
        List<Task> tasks = taskRepository.findByStatus(status);
        for (int i = 0; i < tasks.size(); i++) {
            Task task = new Task();
            if (task.getFinish().isAfter(task.getFinish().plusDays(30))) {
                taskRepository.delete(task);
            }

        }
    }
}
