package com.example.SmartPharmacy.api;

import com.example.SmartPharmacy.model.Role;
import com.example.SmartPharmacy.model.User;
import com.example.SmartPharmacy.service.UserService;
import lombok.Data;
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
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/register")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping("role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUser form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("username")String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }
}
@Data
class RoleToUser{
    private String username;
    private String roleName;
}