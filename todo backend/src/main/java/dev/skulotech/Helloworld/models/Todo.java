package dev.skulotech.Helloworld.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.NotFound;

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
