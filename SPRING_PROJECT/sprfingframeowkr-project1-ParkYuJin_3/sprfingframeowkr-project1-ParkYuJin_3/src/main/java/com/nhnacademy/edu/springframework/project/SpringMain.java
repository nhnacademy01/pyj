package com.nhnacademy.edu.springframework.project;

import ch.qos.logback.core.rolling.RollingFileAppender;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.File;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class SpringMain {
    private static final Log logger = LogFactory.getLog(SpringMain.class);

    public static void main(String[] args) {
        logger.info("SpringMain start" );

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            "com.nhnacademy.edu.springframework.project" )
        ) {
            context.getBean("csvDataLoadService", DataLoadService.class)
                .loadAndMerge();

            Collection<Student> passedStudents =
                context.getBean("defaultStudentService", DefaultStudentService.class)
                    .getPassedStudents();

            logger.info(passedStudents);


            Collection<Student> studentsOrderByScore =
                context.getBean("defaultStudentService", DefaultStudentService.class)
                    .getStudentsOrderByScore();

            logger.info(studentsOrderByScore);

        }


    }
}
