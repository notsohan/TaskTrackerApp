package notsohan.tasks.repositories;

import notsohan.tasks.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID taskListId);
    Optional<Task> findByTaskListIdAndId(UUID taskListId,  UUID id);
    void deleteByTaskListIdAndId(UUID taskListId,  UUID id);
}
