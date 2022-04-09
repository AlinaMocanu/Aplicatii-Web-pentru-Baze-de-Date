package com.example.skincareshop.controller;

import com.example.skincareshop.dto.UserDto;
import com.example.skincareshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/name/{Name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String Name) {
        return ResponseEntity
                .ok()
                .body(userService.getOne(Name));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity
                .ok()
                .body(userService.createUser(userDto));
    }
}
