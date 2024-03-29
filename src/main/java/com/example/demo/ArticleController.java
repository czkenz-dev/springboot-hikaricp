package com.example.demo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    //Fetches all articles
    @GetMapping(value = "articles")
    public ResponseEntity<List<ArticleInfo>> getAllArticles() {
        List<ArticleInfo> responseArticleList = new ArrayList<>();
        List<Article> articleList = articleService.getAllArticles();
        for (Article article : articleList) {
            ArticleInfo ob = new ArticleInfo();
            BeanUtils.copyProperties(article, ob);
            responseArticleList.add(ob);
        }
        return new ResponseEntity<>(responseArticleList, HttpStatus.OK);
    }

    //Creates a new article
    @PostMapping(value = "article")
    public ResponseEntity<Void> addArticle(@RequestBody ArticleInfo articleInfo, UriComponentsBuilder builder) {
        Article article = new Article();
        BeanUtils.copyProperties(articleInfo, article);
        articleService.addArticle(article);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
