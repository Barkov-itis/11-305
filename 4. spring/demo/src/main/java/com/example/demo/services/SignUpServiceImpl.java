package com.example.demo.services;

import com.example.demo.dto.UserForm;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @Override
    public void addUser(UserForm userForm) throws TemplateException, IOException {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .phone(userForm.getPhone())
                .confirmed("CONFIRMED")
                .role(Role.ADMIN)
                .confirmCode(UUID.randomUUID().toString())
                .build();
        usersRepository.save(user);
        writeErrorToFile(user);
        //smsService.sendSms(user.getPhone(), "Регистрация выполнена!");
        //mailService.sendEmailForConfirm(user.getEmail(), user.getConfirmCode());
    }

//    private void writeErrorToFile(Exception e) {
    private void writeErrorToFile(User e) {
        String filePath = "./src/main/resources/static/errors.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("\n[" + LocalDateTime.now() + "] Ошибка: ");
            writer.write(e.toString());
//            for (StackTraceElement ste : e.getStackTrace()) {
//                writer.write("\t " + ste.toString());
//            }
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл лога ошибок: " + ex.getMessage());
        }
    }
}












