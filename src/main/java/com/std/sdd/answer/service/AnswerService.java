package com.std.sdd.answer.service;

import com.std.sdd.answer.entity.Answer;
import com.std.sdd.answer.repository.AnswerRepository;
import com.std.sdd.article.entity.Article;
import com.std.sdd.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Queue;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Article article, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setArticle(article);
        this.answerRepository.save(answer);
    }

}
