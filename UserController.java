package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    @GetMapping("/api/users")
    public List<User> listUsers() {
        return users;
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        user.setId(counter.getAndIncrement());
        users.add(user);
        return user;
    }
}
