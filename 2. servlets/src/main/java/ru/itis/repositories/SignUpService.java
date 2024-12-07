package ru.itis.repositories;

import ru.itis.dto.SignUpForm;

import java.sql.SQLException;

public interface SignUpService {
    void signUp(SignUpForm form) throws SQLException;
}
