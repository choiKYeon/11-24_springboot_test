package com.std.sdd.article.controller;

import com.std.sdd.article.entity.Article;
import com.std.sdd.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model){
        List<Article> article = this.articleService.getList();
        model.addAttribute("articleList" ,article);
        return "article_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){

        return "article_detail";
    }
    @GetMapping("/create")
    public String createArticle(){
        return "article_create";
    }
    @PostMapping("/create")
    public String createArticle(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content){
        this.articleService.create(subject, content);
        return "redirect:/article/list";
    }
}
