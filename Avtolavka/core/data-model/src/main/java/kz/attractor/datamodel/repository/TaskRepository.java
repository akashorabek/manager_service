package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.Client;
import kz.attractor.datamodel.model.Task;
import kz.attractor.datamodel.model.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);
    Page<Task> findAll(Pageable pageable);
}
