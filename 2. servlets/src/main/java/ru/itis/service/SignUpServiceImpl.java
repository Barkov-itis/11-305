package ru.itis.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dto.SignUpForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.sql.SQLException;

public class SignUpServiceImpl implements SignUpService{

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(SignUpForm form) throws SQLException {
        User user = User.builder()
                .name(form.getFirstName())
                .surname(form.getLastName())
                .login(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .age(form.getAge())
                .build();

        usersRepository.save(user);

        // функция проверки пароля
//        Boolean pass = passwordEncoder.matches(rawPss, encodePass);
        // rawPass - пароль полученный с фронта
        // encodePass - ароль из БД
    }
}
