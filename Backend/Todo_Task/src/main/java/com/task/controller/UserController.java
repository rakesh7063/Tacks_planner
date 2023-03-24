package com.task.controller;

import com.task.model.LogDTO;
import com.task.model.User;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/daily-task")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    ResponseEntity<User> userSignUp(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
    }
    @PostMapping("/logIn")
    ResponseEntity<String> userLogInHandle(@RequestBody LogDTO dto){
        return  new ResponseEntity<>(userService.logIn(dto),HttpStatus.ACCEPTED);
    }

}
