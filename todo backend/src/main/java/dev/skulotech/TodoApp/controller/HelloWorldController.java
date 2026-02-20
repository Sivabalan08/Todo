package dev.skulotech.TodoApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    String SeyHello(){
        return "Hello SIVA!";
    }
}
