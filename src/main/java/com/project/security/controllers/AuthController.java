package com.project.security.controllers;

import com.project.security.requests.LoginRequest;
import com.project.security.services.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthController(JwtService jwtService, AuthenticationManager authManager) {
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest lgnReq){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        lgnReq.getEmail(),
                        lgnReq.getPassword()
                )
        );
        return jwtService.generateToken(lgnReq.getEmail());
    }
}
