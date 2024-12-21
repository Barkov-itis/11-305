package ru.itis.service;

import ru.itis.dto.AjaxDto;
import ru.itis.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersService {
    List<User> getAll() throws SQLException;
    void addUser(AjaxDto form) throws SQLException;
}
