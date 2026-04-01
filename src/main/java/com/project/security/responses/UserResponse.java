package com.project.security.responses;

import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String name;
    private String email;

    public UserResponse(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
