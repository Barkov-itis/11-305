package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
