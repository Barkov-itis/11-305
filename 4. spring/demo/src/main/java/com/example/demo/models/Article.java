package com.example.demo.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String name;

    @Column(length = 1000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private User author;

    @ManyToMany
    @JoinTable(name = "article_likes",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "accountId"))
    private List<User> likes;

}
