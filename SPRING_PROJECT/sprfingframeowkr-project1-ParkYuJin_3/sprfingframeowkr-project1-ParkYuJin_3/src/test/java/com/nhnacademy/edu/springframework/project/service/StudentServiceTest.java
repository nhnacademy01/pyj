package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class StudentServiceTest {
//    DataLoadService dataLoadService = new CsvDataLoadService();
//    StudentService studentService = new DefaultStudentService();
//
//    Collection<Student> expectedGetPassedStudents;
//    Collection<Student> expectedGetStudentsOrderByScore;
//
//
//    @BeforeAll
//    void setup() {
//        dataLoadService.loadAndMerge();
//        expectedGetPassedStudents = studentService.getPassedStudents();
//        expectedGetStudentsOrderByScore = studentService.getStudentsOrderByScore();
//    }
//
//    @Test
//    void getgetPassedStudents() {
//        Collection<Student> actualGetPassedStudents = studentService.getPassedStudents();
//
//        assertThat(actualGetPassedStudents).isNotNull();
//        assertThat(actualGetPassedStudents, is(expectedGetPassedStudents));
//    }
//
//    @Test
//    void getStudentsOrderByScore() {
//        Collection<Student> actualGetStudentsOrderByScore = studentService.getStudentsOrderByScore();
//
//        assertThat(actualGetStudentsOrderByScore).isNotNull();
//        assertThat(actualGetStudentsOrderByScore, is(expectedGetStudentsOrderByScore));
//    }
}