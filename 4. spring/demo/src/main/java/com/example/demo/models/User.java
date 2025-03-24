package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<Article> createdArticles;

    @ManyToMany(mappedBy = "likes")
    private List<Article> articles = new ArrayList<>();

    private Role role;
    private String confirmed;
}

