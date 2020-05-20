package zti.todo.repository;

import org.springframework.data.repository.CrudRepository;

import zti.todo.model.Todo;

public interface TodoRepositoryCrud extends CrudRepository<Todo, Integer> {}
