package com.example.demo.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {
    String saveFile(MultipartFile uploadFile);
    void writeFileToResponse (String fileName, HttpServletResponse response);
}
