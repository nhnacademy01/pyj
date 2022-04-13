package com.nhnacademy.edu.springframework.project.service;

import java.util.Collection;

public interface StudentService {
    Collection<Student> getPassedStudents();

    Collection<Student> getStudentsOrderByScore();
}
