package zti.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zti.todo.model.Todo;
import zti.todo.repository.TodoRepositoryCrud;

import java.util.Optional;

@Service
public class TodoService {
	@Autowired
	private TodoRepositoryCrud todoRepository;
	
	public Iterable<Todo> getAllTodos(){
		return todoRepository.findAll();
	}
	
	public Optional<Todo> getTodoById(Integer id) {
		return todoRepository.findById(id);
	}

	public int addTodo(Todo todo) {
		todoRepository.save(todo);
		return 1;
	}
	
	public int deleteTodo(Integer id) {
		todoRepository.deleteById(id);
		return 1;
	}
	
	public void updateTodo(Integer id, Todo todo) {
		Optional<Todo> todoFromDb = todoRepository.findById(id);
	    if(todoFromDb.isPresent()) {
	    	todoRepository.save(todo);
	    } else {
	    	Todo newTodo = new Todo();
	    	newTodo.setId(id);
	    	newTodo.setTitle(todo.getTitle());
	    	todoRepository.save(newTodo);
	    }
	}

}
