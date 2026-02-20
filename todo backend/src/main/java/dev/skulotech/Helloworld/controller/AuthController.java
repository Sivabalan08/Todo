package dev.skulotech.Helloworld.controller;

import dev.skulotech.Helloworld.models.User;
import dev.skulotech.Helloworld.repository.UserRepository;
import dev.skulotech.Helloworld.service.UserService;
import dev.skulotech.Helloworld.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
        private final UserService userService;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String ,String> body){
        String email = body.get("email");
        String password = passwordEncoder.encode(body.get("password"));

        if(userRepository.findByEmail(email).isPresent()){
            //return new ResponseEntity<>("email already exists",HttpStatus.CONFLICT);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        userService.createUser(User.builder().email(email).password(password).build());
        return new ResponseEntity<>("Succesfully Registered",HttpStatus.CREATED);


    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String ,String> body){
        String email = body.get("email");
        String password = body.get("password");

        var userOptional =userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            return new ResponseEntity<>("User not Registered",HttpStatus.UNAUTHORIZED);
        }
        User user =userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())){
            return new ResponseEntity<>("Invalid User",HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("token",token));

    }
}
