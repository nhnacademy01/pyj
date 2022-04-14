package com.nhnacademy.edu.springframework.project.repository;

import java.util.List;
import org.springframework.context.annotation.Bean;

public interface Scores {
    void load();

    List<Score> findAll();
}
