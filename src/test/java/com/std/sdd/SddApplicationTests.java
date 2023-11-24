package com.std.sdd;

import com.std.sdd.article.entity.Article;
import com.std.sdd.article.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SddApplicationTests {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    @DisplayName("데이터 생성")
    void join() {
        Article a1 = new Article();
        a1.setSubject("첫번째 시험이네요");
        a1.setContent("너무 재밌습니다.");
        a1.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(a1);

        Article a2 = new Article();
        a2.setSubject("두번째 시험도 기대됩니다.");
        a2.setContent("너무 기대됩니다.");
        a2.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(a2);
    }

}
