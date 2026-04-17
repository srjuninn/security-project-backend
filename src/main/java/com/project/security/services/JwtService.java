package com.project.security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data

public class JwtService {

    private final String SECRET = "doyourjumpssonnobodyyesdoorthedadisawesomethereisnoway";

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
