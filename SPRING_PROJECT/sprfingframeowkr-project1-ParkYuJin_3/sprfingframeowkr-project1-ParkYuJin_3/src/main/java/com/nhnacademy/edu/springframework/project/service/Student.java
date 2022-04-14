package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;

public class Student implements Comparable {
    private final int seq;
    private final String name;
    private Score score;

    public Student(int seq, String name) {
        this.seq = seq;
        this.name = name;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public int getSeq() {
        return seq;
    }

    @Override
    public String toString() {
        return "Student{" +
            "seq=" + seq +
            ", name='" + name + '\'' +
            ", score=" + score +
            '}' + '\n';
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return this.score.getScore() - student.getScore().getScore();
    }

}

