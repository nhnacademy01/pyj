package com.nhnacademy.edu.springframework.project.service;


import com.nhnacademy.edu.springframework.project.SpringMain;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class DefaultStudentService implements StudentService {
    private final Students studentRepository;

    public DefaultStudentService(
        Students studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Collection<Student> getPassedStudents() {
        // DONE 1 : pass 한 학생만 반환하도록 수정하세요.
        Collection<Student> students = studentRepository.findAll();
        return students.stream()
            .filter(student -> student.getScore().getScore() >= 60)
            .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        // DONE 4 : 성적 순으로 학생 정보를 반환합니다.

        Collection<Student> students = studentRepository.findAll();
        return students.stream().sorted().collect(Collectors.toList());
    }
}

