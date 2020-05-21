package zti.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zti.todo.model.Todo;

import java.util.List;

public interface TodoRepositoryJpa extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByCategory(String categoryName);

    @Query("SELECT t from Todo t where LOWER(t.title) = LOWER(t.subtitle)")
    List<Todo> findAllWithSameTitleSubtitle();
}
