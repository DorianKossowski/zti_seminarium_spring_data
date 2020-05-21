package zti.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zti.todo.model.Todo;

import java.util.List;

public interface TodoRepositoryJpa extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByCategory(String categoryName);
}
