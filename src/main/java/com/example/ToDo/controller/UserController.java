package com.example.ToDo.controller;

import com.example.ToDo.model.User;
import com.example.ToDo.service.UserService;
import com.example.ToDo.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        try {
            return userService.login(user.getUsername(), user.getPassword());
        } catch (AuthenticationException e) {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
