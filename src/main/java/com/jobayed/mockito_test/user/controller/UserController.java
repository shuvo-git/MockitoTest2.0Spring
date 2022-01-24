package com.jobayed.mockito_test.user.controller;

import com.jobayed.mockito_test.user.model.User;
import com.jobayed.mockito_test.user.service.UserService;
import com.jobayed.mockito_test.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }
}
