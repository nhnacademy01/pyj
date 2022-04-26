package com.nhnacademy.cookie;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        servletContext.setInitParameter("url", "https://nhnacademy.com/");
        servletContext.setInitParameter("counterFile", "counter.dat");
    }
    // context-param을 통해서 했던 것을 이런식으로 선언해 줄 수도 있다
}
