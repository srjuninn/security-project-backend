package com.project.security.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, toStrign, equalsAndHashCode, RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Column(unique = true)
    private String email;
    private String password;
}
