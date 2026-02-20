package dev.skulotech.TodoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotNull
    @NotBlank
            //@Schema(name = "title",example = "complete spring boot")
    String title;
    Boolean isCompleted;
}
