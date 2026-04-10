package com.project.security.controllers;

import com.project.security.requests.UserRequest;
import com.project.security.responses.UserResponse;
import com.project.security.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userReq){
        UserResponse userRes = userService.createUser(userReq);
        return ResponseEntity.ok(userRes);
    }

    @GetMapping("/admin")
    public String admin(){
        return "acesso admin!";
    }

}
