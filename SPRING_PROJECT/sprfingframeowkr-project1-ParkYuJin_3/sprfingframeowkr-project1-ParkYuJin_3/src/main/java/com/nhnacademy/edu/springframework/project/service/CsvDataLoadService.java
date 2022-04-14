package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.SpringMain;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class CsvDataLoadService implements DataLoadService {

    private final Students students;
    private final Scores scores;

    public CsvDataLoadService(Students csvStudents,
                              Scores csvScore) {
        this.students = csvStudents;
        this.scores = csvScore;
    }

    public void loadAndMerge() {
        scores.load();

        students.load();
        students.merge(scores.findAll());
    }
}
