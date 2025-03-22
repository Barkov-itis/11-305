package com.example.demo.services;

import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long id);

    ArticleDto addArticle(Long userId, ArticleForm articleForm);

    ArticleDto like(Long userId, Long articleId);
}
