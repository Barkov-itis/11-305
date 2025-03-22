package com.example.demo.services;

import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.ArticleForm;
import com.example.demo.models.Article;
import com.example.demo.models.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> getByUser(Long id) {
        Optional<User> user = usersRepository.findById(id);
        List<Article> articlesOfUser = user.get().getCreatedArticles();
        return ArticleDto.articleList(articlesOfUser);
    }

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        Optional<User> author = usersRepository.findById(userId);
        Article newArticle = Article.builder()
                .text(articleForm.getText())
                .name(articleForm.getName())
                .author(author.get())
                .build();
        articleRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }
}
