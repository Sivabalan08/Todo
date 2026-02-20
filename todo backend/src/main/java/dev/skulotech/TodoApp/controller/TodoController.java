package dev.skulotech.TodoApp.controller;

import dev.skulotech.TodoApp.models.Todo;
import dev.skulotech.TodoApp.service.TodoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todo")
@Slf4j
public class TodoController {
    @Autowired
    private TodoService todoService;
    //PATH VARIABLE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "TOdo sucessful"),
            @ApiResponse(responseCode = "404",description = "Todo was not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id) {
        try{
            Todo createTodo =todoService.getTodoById(id);
            return new ResponseEntity<>(createTodo, HttpStatus.OK);
        }catch (RuntimeException exception){
            log.info("Error");//slf4j
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getTodos(),HttpStatus.OK);
    }
    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodosPages(page, size),HttpStatus.OK);

    }

    @PostMapping ("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo ) {
        //todoId=22 LIKE WISE PASSWORD USAGE
        Todo createTodo =todoService.createTodo(todo);
        return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
    }
    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id){
       todoService.deleteTodoByID(id);
    }
}