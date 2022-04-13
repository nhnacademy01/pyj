package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.annotation.Bean;

public class DefaultGradeQueryService implements GradeQueryService {
    Students students = CsvStudents.getInstance();
    Collection<Student> collection =  students.findAll();

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // DONE 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        List<Score> scoreList = new ArrayList<>();

        Iterator<Student> ir = collection.iterator();
        while(ir.hasNext()){
            Student student = ir.next();
            String studentName = student.getName();
            if(studentName.equals(name)){
                scoreList.add(student.getScore());
            }
        }
        return scoreList;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // DONE 6 : 학생 번호로 점수를 반환합니다.
        Iterator<Student> ir = collection.iterator();
        while(ir.hasNext()){
            Student student = ir.next();
            int studentName = student.getSeq();
            if(studentName == seq){
                return student.getScore();
            }
        }
        return null;
    }

}
