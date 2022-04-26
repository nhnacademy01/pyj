package com.nhnacademy.initializer;

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
        servletContext.setInitParameter("onion", "1000" );
        servletContext.setInitParameter("egg", "2000");
        servletContext.setInitParameter("welshOnion", "500");
        servletContext.setInitParameter("apple", "200");
    }
}

