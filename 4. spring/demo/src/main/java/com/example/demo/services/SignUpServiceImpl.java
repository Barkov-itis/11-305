package com.example.demo.services;

import com.example.demo.dto.UserForm;
import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .build();
        usersRepository.save(user);
    }
}
