package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DefaultStudentService implements StudentService {
    Students studentRepository = CsvStudents.getInstance();
    Map<Integer, Student> studentMap = studentRepository.getStudents();

    @Override
    public Collection<Student> getPassedStudents() {
        // TODO 1 : pass 한 학생만 반환하도록 수정하세요.
        Collection<Student> resultCollection = new ArrayList<>();

        Iterator<Integer> keys = studentMap.keySet().iterator();
        while (keys.hasNext()) {
            Integer key = keys.next();
            if (studentMap.get(key).getScore().getScore() >= 70) {
                resultCollection.add(studentMap.get(key));
            }
        }
        return resultCollection;
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        // TODO 4 : 성적 순으로 학생 정보를 반환합니다.
        Collection<Student> resultCollection = new ArrayList<>();

        Iterator<Integer> keys = studentMap.keySet().iterator();
        while (keys.hasNext()) {
            Integer key = keys.next();
            if (studentMap.get(key).getScore().getScore() >= 70) {
                resultCollection.add(studentMap.get(key));
            }
        }
        return resultCollection;
    }

}
