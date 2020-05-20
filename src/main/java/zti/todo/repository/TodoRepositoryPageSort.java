package zti.todo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zti.todo.model.Todo;

public interface TodoRepositoryPageSort extends PagingAndSortingRepository<Todo, Integer> {
}