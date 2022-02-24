package com.example.module7.controller;

import com.example.module7.entity.User;
import com.example.module7.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("{id}")
    public User update(@RequestBody User user) {
        return userService.update(user, user.getId());
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}