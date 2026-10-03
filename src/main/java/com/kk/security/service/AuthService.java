package com.kk.security.service;

import com.kk.security.dto.RegisterRequest;
import com.kk.security.entity.User;
import com.kk.security.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        String encodePassword = passwordEncoder.encode(request.getPassword());

        System.out.println("encodePassword : " + encodePassword);
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(encodePassword);
        user.setRole("USER");

        userRepository.save(user);
    }
}
