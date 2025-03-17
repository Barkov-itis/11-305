package com.example.demo.services;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }
}
