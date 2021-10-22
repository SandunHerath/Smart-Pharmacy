package com.example.SmartMedicalCenter.api;

import com.example.SmartMedicalCenter.model.Medicine;
import com.example.SmartMedicalCenter.model.User;
import com.example.SmartMedicalCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("username")String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }
    @PutMapping("update/{username}")
    public ResponseEntity<User>updateProduct(@PathVariable("username")String username, @RequestBody User user){
        return ResponseEntity.ok().body(userService.update(user,username));
    }
    @DeleteMapping("{username}")
    public ResponseEntity<User>deleteProduct(@PathVariable("username")String username){
        return ResponseEntity.ok().body(userService.delete(username));
    }
}