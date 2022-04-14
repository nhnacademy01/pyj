package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.MainConfiguration;
import com.nhnacademy.edu.springframework.project.service.Student;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MainConfiguration.class)
class StudentsTest {
    private Students students;
    private Scores scores;

    @BeforeAll
    void setup(){
        scores = new CsvScores();
        students = new CsvStudents();

        students.load();
        scores.load();
    }

    @Test
    @DisplayName("student.csv 파일을 잘 읽어오는지 테스트 ")
    void load() {
        // 경로 틀렸을 때 에러 잘 나는지
//        assertThrows(IllegalStateException.class, () ->{
//            students.load();
//        });
    }

    @Test
    @DisplayName("student의 모든 객체를 잘 반환하는지")
    void findAll() {
        assertThat(students.findAll()).isNotNull();
        assertThat(students.findAll().size()).isEqualTo(4);

    }

    @Test
    @DisplayName("load 후 Students 안에 Score가 잘 들어오는지 ")
    void merge() {
//
//        assertThat(students.findAll().stream().filter(student -> student.getScore().getScore()).findFirst(), is(expectedStudents));
//        assertThat(students.findAll().size(), is(expectedStudents.size()));
    }
}