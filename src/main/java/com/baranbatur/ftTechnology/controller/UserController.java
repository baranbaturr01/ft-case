package com.baranbatur.ftTechnology.controller;

import com.baranbatur.ftTechnology.model.User;
import com.baranbatur.ftTechnology.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save", produces = {"application/json"})
    public boolean saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return true;
    }
}
