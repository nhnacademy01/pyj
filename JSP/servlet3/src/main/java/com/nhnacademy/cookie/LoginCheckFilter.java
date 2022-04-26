package com.nhnacademy.cookie;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
    List<String> urls = Arrays.asList("/login", "/login.html", "/logout", "/loginForm");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String blackList = filterConfig.getInitParameter("blacklist");
        String[] arr = blackList.split("\n");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        String requestUri = ((HttpServletRequest) servletRequest).getRequestURI();


        // blacklist
        if (urls.contains(requestUri)) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);

            if (Objects.nonNull(session)) {
//                RequestDispatcher rd = servletRequest.getRequestDispatcher("/loginForm");
//                rd.forward(servletRequest, servletResponse);

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        }
    }

}
