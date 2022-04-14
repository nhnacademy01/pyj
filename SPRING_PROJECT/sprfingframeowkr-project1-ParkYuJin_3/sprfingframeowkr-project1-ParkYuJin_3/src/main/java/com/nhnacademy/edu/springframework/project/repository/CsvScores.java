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
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * DONE 2 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
@Repository
public class CsvScores implements Scores {

    private final List<Score> scores = new ArrayList<>();

    // DONE 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
           File file = new File( getClass().getClassLoader().getResource("data/score.csv").getFile());
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String str;
            while((str=reader.readLine())!= null){
                String[] scoreList = str.split(",");
                scores.add(new Score(Integer.parseInt(scoreList[0]), Integer.parseInt(scoreList[1])));
            }

        } catch (FileNotFoundException e) {
            throw new FileIsNotExistException("cannot find file");
        } catch (IOException e) {
            throw new FileIOException("file input output is wrong");
        }
    }

    @Override
    public List<Score> findAll() {
        return this.scores;
    }
}
