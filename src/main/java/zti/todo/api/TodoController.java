package zti.todo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zti.todo.model.Todo;
import zti.todo.service.TodoService;

@RequestMapping("api/v1/todos")
@RestController
@CrossOrigin("*")
public class TodoController {
	@Autowired
	private TodoService todoservice;

	@GetMapping
	public @ResponseBody Iterable<Todo> getTodos(){
		return todoservice.getAllTodos();
	}
	
	@GetMapping(path = "{id}")
	public @ResponseBody Todo getTodoById(@PathVariable("id") Integer id){
		return todoservice.getTodoById(id).orElse(null);
	}
	
	@PostMapping
	public void addTodo(@RequestBody Todo newTodo) {
		todoservice.addTodo(newTodo);
	}
	
	@PutMapping(path = "{id}")
	public void updateTodo(@PathVariable("id") Integer id, @RequestBody Todo todo) {
		todoservice.updateTodo(id, todo);
	}
	
	@DeleteMapping(path = "{id}")
	public void delTodo(@PathVariable("id") Integer id){
		todoservice.deleteTodo(id);
	}
	
}
