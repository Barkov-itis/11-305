package ru.itis.service;

import ru.itis.dto.AjaxDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.sql.SQLException;
import java.util.List;

public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return usersRepository.findAll();
    }

    @Override
    public void addUser(AjaxDto form) throws SQLException {
        User user = User.builder()
                .name(form.getFirstName())
                .surname(form.getLastName())
                .login(form.getEmail())
                .age(22)
                .password("weterytuyiuliu")
                .build();
        usersRepository.save(user);
    }
}
