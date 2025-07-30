package com.ceuDigital.api.controller;

import com.ceuDigital.api.domain.user.UserRequestDTO;
import com.ceuDigital.api.domain.user.User;
import com.ceuDigital.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create (@RequestBody UserRequestDTO userDTO)
    {
        User newUser = this.userService.createUser(userDTO);

        return ResponseEntity.ok(newUser);
    }
}