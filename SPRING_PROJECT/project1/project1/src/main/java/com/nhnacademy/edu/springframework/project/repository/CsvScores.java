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
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * TODO 2 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
@Component
public class CsvScores implements Scores {

    private static final Scores INSTANCE = new CsvScores();

    private final List<Score> scores = new ArrayList<>();

    private CsvScores() {
    }

    public static Scores getInstance() {
        return INSTANCE;
    }

    // DONE 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        File csv = new File(
            "C:\\Users\\park\\Desktop\\NHN\\NHN_SRC\\SPRING_PROJECT\\project1\\project1\\src\\main\\resources\\data\\score.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.;
                scores.add(new Score(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])));
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
    public List<Score> findAll() {
        return this.scores;
    }
}
