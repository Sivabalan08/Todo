package dev.skulotech.TodoApp.service;

import dev.skulotech.TodoApp.models.User;
import dev.skulotech.TodoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;    //dependancy

    /*public TodoService(){
        todoRepository = new TodoRepository();//object create by me
    }*/

    public User createUser(User user){
        return userRepository.save(user);

    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
    
}
