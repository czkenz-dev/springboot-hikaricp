package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        List<Article> list = new ArrayList<>();
        articleRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void addArticle(Article article) {
        articleRepository.save(article);
    }
}
