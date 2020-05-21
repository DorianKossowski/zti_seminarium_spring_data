package zti.todo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zti.todo.model.Todo;
import zti.todo.service.TodoService;

import java.util.List;

@RequestMapping("api/v1/todos")
@RestController
@CrossOrigin("*")
public class TodoController {
    @Autowired
    private TodoService todoservice;

    @GetMapping
    public @ResponseBody Iterable<Todo> getTodos(@RequestParam(required = false) Integer page,
                                                 @RequestParam(required = false) Integer size) {
        if(page!=null && size != null) {
            return todoservice.getAllWithPagination(page, size);
        }
        return todoservice.getAllTodos();
    }

    @GetMapping(path = "/sort/{sortByName}")
    public @ResponseBody Iterable<Todo> getSortedTodos(@PathVariable String sortByName) {
        return todoservice.getAllSortedBy(sortByName);
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Todo getTodoById(@PathVariable("id") Integer id) {
        return todoservice.getTodoById(id).orElse(null);
    }

    @GetMapping(path = "/category/{categoryName}")
    public @ResponseBody List<Todo> getTodoByCategory(@PathVariable("categoryName") String categoryName) {
//        return todoservice.getAllByCategoryExample(categoryName);
        return todoservice.getAllByCategory(categoryName);
    }

    @GetMapping(path = "/same")
    public @ResponseBody List<Todo> getTodoWithSameTitleSubtitle() {
        return todoservice.getAllWithSameTitleSubtitle();
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
    public void delTodo(@PathVariable("id") Integer id) {
        todoservice.deleteTodo(id);
    }
}
