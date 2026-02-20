package dev.skulotech.Helloworld.repository;

//CRUD-Create Read Update Delete


import dev.skulotech.Helloworld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
