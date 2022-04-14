package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.exception.FileIOException;
import com.nhnacademy.edu.springframework.project.exception.FileIsNotExistException;
import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * DONE 3 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/

/**
 * DONE 7 :
 * singleton 클래스를 만드세요.
 */

@Repository
public class CsvStudents implements Students {

    private final Map<Integer, Student> students = new HashMap<>();

    public Map<Integer, Student> getStudents() {
        return students;
    }

    // DONE 6 : student.csv 파일에서 데이터를 읽어 student 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        File file = new File(this.getClass().getClassLoader().getResource("data/student.csv").getFile());

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String str;
            while((str=reader.readLine())!= null){
                String[] studentList = str.split(",");
                students.put(Integer.parseInt(studentList[0]), new Student(Integer.parseInt(studentList[0]), studentList[1]));
            }

        } catch (FileNotFoundException e) {
            throw new FileIsNotExistException("cannot find file");
        } catch (IOException e) {
            throw new FileIOException("file input output is wrong");
        }
    }

    @Override
    public Collection<Student> findAll() {
        return this.students.values();
    }

    /**
     * DONE 8 : students 데이터에 score 정보를 추가하세요.
     *
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        scores.forEach(score ->
            students
                .get(score.getStudentSeq())
                .setScore(score));
    }

}
