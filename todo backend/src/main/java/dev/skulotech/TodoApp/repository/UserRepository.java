package dev.skulotech.TodoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.skulotech.TodoApp.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
