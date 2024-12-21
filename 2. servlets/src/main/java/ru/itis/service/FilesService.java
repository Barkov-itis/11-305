package ru.itis.services;

import ru.itis.models.FileInfo;

import java.io.InputStream;
import java.io.OutputStream;

public interface FilesService {
    void saveFileToStorage(InputStream file, String originalFileName, String contentType, Long size);
    void writeFileFromStorage(Long fileId, OutputStream outputStream);
    FileInfo getFileInfo(Long fileId);
}

