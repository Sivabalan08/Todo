package dev.skulotech.TodoApp.service;

import dev.skulotech.TodoApp.models.Todo;
import dev.skulotech.TodoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    //autowiring
    @Autowired
    private TodoRepository todoRepository;    //dependancy

    /*public TodoService(){
        todoRepository = new TodoRepository();//object create by me
    }*/

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);

    }
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
    public Page<Todo> getAllTodosPages(int page, int size){
        PageRequest pageable= PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }
    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public void deleteTodoByID(long id){
        todoRepository.delete(getTodoById(id));
    }
    public void deleteTodo(Todo todo){
        todoRepository.delete(todo);
    }
}

//Baan