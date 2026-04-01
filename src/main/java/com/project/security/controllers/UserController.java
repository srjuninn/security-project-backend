package com.project.security.controllers;

import com.project.security.requests.UserRequest;
import com.project.security.responses.UserResponse;
import com.project.security.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userReq){
        UserResponse userRes = userService.createUser(userReq);
        return ResponseEntity.ok(userRes);
    }

}
