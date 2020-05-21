package zti.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zti.todo.model.Todo;

public interface TodoRepositoryJpa extends JpaRepository<Todo, Integer> {
}
