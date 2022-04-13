package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.exception.FileIOException;
import com.nhnacademy.edu.springframework.project.exception.FileIsNotExistException;
import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * TODO 3 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/

/**
 * DONE 7 :
 * singleton 클래스를 만드세요.
 */
@Component
public class CsvStudents implements Students {

    private static final Students INSTANCE = new CsvStudents();

    private final Map<Integer, Student> students = new HashMap<>();

    private CsvStudents() {
    }

    public static Students getInstance() {
        return INSTANCE;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    // DONE 6 : student.csv 파일에서 데이터를 읽어 student 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        List<List<String>> csvList = new ArrayList<List<String>>();
        File csv = new File(
            "C:\\Users\\park\\Desktop\\NHN\\NHN_SRC\\SPRING_PROJECT\\project1\\project1\\src\\main\\resources\\data\\student.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.;
                students.put(Integer.parseInt(lineArr[0]), new Student(Integer.parseInt(lineArr[0]), lineArr[1]));
            }
        } catch (FileNotFoundException e) {
            throw new FileIsNotExistException("cannot find file");
        } catch (IOException e) {
            throw new FileIOException("file input output is wrong");
        } finally {
            try {
                if (br != null) {
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    @Bean
    public Collection<Student> findAll() {
        return this.students.values();
    }

    /**
     * DONE 8 : students 데이터에 score 정보를 추가하세요.
     *
     * @param scores
     */
    @Override
    @Bean
    public void merge(Collection<Score> scores) {
        scores.forEach(score ->
            students
                .get(score.getStudentSeq())
                .setScore(score));
    }

}
