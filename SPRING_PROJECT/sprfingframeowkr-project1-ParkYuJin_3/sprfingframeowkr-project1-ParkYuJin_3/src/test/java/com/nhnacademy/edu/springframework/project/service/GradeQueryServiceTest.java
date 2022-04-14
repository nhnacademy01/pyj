package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class GradeQueryServiceTest {

    private Students students;
    private Scores scores;
    private DataLoadService dataLoadService;

    private GradeQueryService gradeQueryService;
    List<Score> expectedStudentScoreByName ;
    Score expectedStudentScore;


    @BeforeAll
    void setup() {
        scores = new CsvScores();
        students = new CsvStudents();
        dataLoadService = new CsvDataLoadService(students, scores);

        dataLoadService.loadAndMerge();
        gradeQueryService = new DefaultGradeQueryService(students);
        expectedStudentScoreByName = gradeQueryService.getScoreByStudentName("A");
        expectedStudentScore = gradeQueryService.getScoreByStudentSeq(1);
    }


    @Test
    void getScoreByStudentName() {
        assertThat(gradeQueryService.getScoreByStudentName("A")).isNotNull();
        assertThat(gradeQueryService.getScoreByStudentName("A").get(0), is(expectedStudentScore));
    }

    @Test
    void getScoreByStudentSeq() {
        assertThat(gradeQueryService.getScoreByStudentSeq(1)).isNotNull();
        assertThat(gradeQueryService.getScoreByStudentSeq(1), is(expectedStudentScore));
    }
}