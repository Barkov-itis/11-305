package com.example.demo.repository;

import com.example.demo.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName (String fileName);
}
