package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.Collection;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DataLoadServiceTest {

    private Students students;
    private Scores scores;
    private DataLoadService dataLoadService;

    private Collection<Student> expectedStudents;
    private List<Score> expectedScore;


    @BeforeAll
    void setUp() {
        scores = new CsvScores();
        students = new CsvStudents();
        dataLoadService = new CsvDataLoadService(students, scores);

        students.load();
        scores.load();
        dataLoadService.loadAndMerge();

        expectedStudents = students.findAll();
        expectedScore = scores.findAll();
    }

    @Test
    void loadAndMerge() {
        assertThat(dataLoadService).isNotNull();

        assertThat(students.findAll(), is(expectedStudents));
        assertThat(students.findAll().size(), is(expectedStudents.size()));

        assertThat(students.findAll()).isNotNull();
        MatcherAssert.assertThat(students.findAll(), is(expectedStudents));
        MatcherAssert.assertThat(students.findAll().size(), is(expectedStudents.size()));

    }
}