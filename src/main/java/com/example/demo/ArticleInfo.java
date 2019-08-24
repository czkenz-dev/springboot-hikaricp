package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ArticleInfo {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long articleId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;
}
