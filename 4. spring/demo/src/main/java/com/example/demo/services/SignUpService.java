package com.example.demo.services;

import com.example.demo.dto.UserForm;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface SignUpService {
    public void addUser(UserForm userForm) throws TemplateException, IOException;
}
