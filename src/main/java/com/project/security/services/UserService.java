package com.project.security.services;

import com.project.security.entities.UserEntity;
import com.project.security.enums.Role;
import com.project.security.repositories.UserRepository;
import com.project.security.requests.UserRequest;
import com.project.security.responses.UserResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest userReq){
        if(userReq == null){
            throw new IllegalArgumentException("os dados inseridos estão inválidos");
        }
        if (userRepository.findByEmail(userReq.getEmail()).isPresent()) {
            throw new DuplicateKeyException("já existe um usuário com esse email cadastrado");
        }
//        chamando a função de encriptografar a senha e passando como parâmetro a senha
        UserEntity newUser = new UserEntity(userReq.getName(), userReq.getEmail(), passwordEncoder.encode(userReq.getPassword()), Role.ROLE_USER);
        userRepository.save(newUser);
        return new UserResponse(newUser.getId(), newUser.getName(), newUser.getEmail());
    }
}
