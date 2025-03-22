package com.example.demo.controllers;

import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.ArticleForm;
import com.example.demo.models.Article;
import com.example.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") Long userId,
                                    @ModelAttribute ArticleForm articleForm)  {
        System.out.println(userId);
        return articleService.addArticle(userId, articleForm);
    }

    @GetMapping("/users/{user-id}/articles")
    public String getArticleOfUser(@PathVariable("user-id") Long userId, Model model){
        model.addAttribute("articles", articleService.getByUser(userId));
        return "article_page";
    }

    @PostMapping("/users/{user-id}/article/{article-id}/like")
    @ResponseBody
    public Object like(@PathVariable ("user-id") Long userId,
                       @PathVariable ("article-id") Long articleId) {
        return articleService.like(userId, articleId);
    }
}
