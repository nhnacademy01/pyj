package com.nhnacademy.edu.springframework.project.exception;

public class FileIOException extends IllegalStateException{

    public FileIOException(String s) {
        super(s);
    }
}
