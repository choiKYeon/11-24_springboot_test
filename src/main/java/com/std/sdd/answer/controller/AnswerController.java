package com.std.sdd.answer.controller;

import com.std.sdd.answer.form.AnswerForm;
import com.std.sdd.answer.service.AnswerService;
import com.std.sdd.article.entity.Article;
import com.std.sdd.article.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final ArticleService articleService;
    private final AnswerService answerService;
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Article article = this.articleService.getArticle(id);
        if (bindingResult.hasErrors()){
            model.addAttribute("article" , article);
            return "article_detail";
        }
        this.answerService.create(article, answerForm.getContent());
        return String.format("redirect:/article/detail/%s", id);
    }
}
