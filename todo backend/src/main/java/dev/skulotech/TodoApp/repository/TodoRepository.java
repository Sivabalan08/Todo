package dev.skulotech.TodoApp.repository;

//CRUD-Create Read Update Delete


import dev.skulotech.TodoApp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
