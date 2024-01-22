package dev.team2.zoopoli.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.team2.zoopoli.Models.User;
import dev.team2.zoopoli.Services.UserService;

@RestController
@RequestMapping(path = "${api-endpoint}/users")
public class UserController {
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<User> index () {
        return service.getAll();
    }

    @PostMapping(path = "")
    public ResponseEntity<User> create(@NonNull @RequestBody User user) {
        User newUser = service.save(user);
        return ResponseEntity.status(201).body(newUser);
    }

}
