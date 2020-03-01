package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


@RequestMapping("/users")
@RestController
public class UserController implements Serializable {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    private ResponseEntity addUser(@RequestBody User user) {

        if (user == null) {
            return ResponseEntity.badRequest().body("EMPTY OBJECT");
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body("SUCCESS");
    }

    @GetMapping(value = "/getUser/{userId}")
    private ResponseEntity<User> getUser(@PathVariable(name = "userId") String userId) {

        if (userId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        User u = userService.getUser(Long.valueOf(userId));
        return new ResponseEntity<User>(u, HttpStatus.OK);
    }

}
