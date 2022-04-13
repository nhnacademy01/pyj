package com.nhnacademy.edu.springframework.project.exception;

import java.io.FileNotFoundException;

public class FileIsNotExistException extends IllegalStateException {
    public FileIsNotExistException(String s) {
        super(s);
    }
}
