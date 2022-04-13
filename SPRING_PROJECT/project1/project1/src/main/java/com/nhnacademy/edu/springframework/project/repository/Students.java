package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Component;

public interface Students {
    void load();

    Collection<Student> findAll();

    void merge(Collection<Score> scores);

    Map<Integer, Student> getStudents();
}
