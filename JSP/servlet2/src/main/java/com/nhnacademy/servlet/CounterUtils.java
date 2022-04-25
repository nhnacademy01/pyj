package com.nhnacademy.servlet;

import java.util.Optional;
import javax.servlet.ServletContext;

public class CounterUtils {
    private CounterUtils(){
        throw new IllegalArgumentException("Utility class"); 
    } // 이 클래스는 객체화 될 일이 없다
    // 그래서 객체화 되었을 때 방지를 위해 생성자를 private로 하고, 에러 던지는거로
    
    public static void increaseCounter(ServletContext servletContext){
        Integer count = Optional.ofNullable((Integer) servletContext.getAttribute("counter")).orElse(0);
        count++;
        servletContext.setAttribute("counter", count);
    }
}
