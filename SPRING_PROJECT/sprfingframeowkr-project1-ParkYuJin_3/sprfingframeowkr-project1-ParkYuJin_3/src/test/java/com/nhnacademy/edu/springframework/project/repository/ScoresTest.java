package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.MainConfiguration;
import com.nhnacademy.edu.springframework.project.service.Student;
import java.lang.annotation.Documented;
import java.util.Collection;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MainConfiguration.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class ScoresTest {
    private Scores scores;

    @BeforeAll
    void setup(){
        scores = new CsvScores();
        scores.load();
    }

    @Test
    @DisplayName("scores.csv 파일을 잘 읽어오는지 테스트 ")
    void load() {
        // 에러 잘 나는지
//        assertThrows(IllegalStateException.class, () ->{
//            scores.load();
//            });
    }

    @Test
    @DisplayName("scores의 모든 객체를 잘 반환하는지")
    void findAll() {
        List<Score> expectedScore = scores.findAll();

        assertThat(expectedScore).isNotNull();
        assertThat(expectedScore.size()).isEqualTo(3);
    }
}