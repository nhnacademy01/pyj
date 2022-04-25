package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {
    int count = 0;
    int totalCount = 0;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//
//        count = Integer.parseInt(config.getInitParameter("count"));
//        totalCount += count;

        count = Integer.parseInt(config.getInitParameter("count"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        CounterUtils.increaseCounter(getServletContext());

        PrintWriter out = resp.getWriter();
        totalCount += count;
        out.println(count);
        out.println("totalCount : " + totalCount);
    }
}
