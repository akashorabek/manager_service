package kz.attractor.datamodel.repository;

import kz.attractor.datamodel.model.TaskComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {
    Page<TaskComment> findAll(Pageable pageable);
}
