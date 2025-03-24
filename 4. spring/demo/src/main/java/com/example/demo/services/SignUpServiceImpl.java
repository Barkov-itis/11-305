package com.example.demo.services;

import com.example.demo.dto.UserForm;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .confirmed("CONFIRMED")
                .role(Role.ADMIN)
                .build();
        usersRepository.save(user);
    }
}
