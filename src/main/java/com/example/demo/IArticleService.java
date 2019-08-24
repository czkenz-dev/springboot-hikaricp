package com.example.demo;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();

    void addArticle(Article article);
}
