package com.OpenCode.QuestionnarySystem.controller;

import com.OpenCode.QuestionnarySystem.model.User;
import com.OpenCode.QuestionnarySystem.repository.UserRepository;
import com.OpenCode.QuestionnarySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
