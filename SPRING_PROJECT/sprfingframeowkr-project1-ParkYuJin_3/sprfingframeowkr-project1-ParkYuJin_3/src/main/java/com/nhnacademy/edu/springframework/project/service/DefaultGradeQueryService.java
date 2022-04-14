package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.SpringMain;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class DefaultGradeQueryService implements GradeQueryService {

    private final Students students;

    public DefaultGradeQueryService(
        Students students) {
        this.students = students;
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {

        Collection<Student> studentsAll = students.findAll();
        // DONE 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        List<Score> scoreList = new ArrayList<>();

        scoreList.add(studentsAll.stream()
            .filter(student -> student.getName().equals(name))
            .findFirst().orElse(null).getScore());

        return scoreList;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        Collection<Student> studentsAll = students.findAll();

        // DONE 6 : 학생 번호로 점수를 반환합니다.
        return studentsAll.stream()
            .filter(student -> student.getSeq() == seq).findFirst().orElse(null).getScore();
    }
}
