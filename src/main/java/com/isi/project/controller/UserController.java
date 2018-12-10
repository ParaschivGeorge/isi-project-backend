package com.isi.project.controller;

import com.isi.project.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
