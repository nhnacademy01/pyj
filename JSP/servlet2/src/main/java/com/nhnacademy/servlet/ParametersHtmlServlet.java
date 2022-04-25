package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParametersHtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        CounterUtils.increaseCounter(getServletContext());

        PrintWriter out = resp.getWriter();
        out.println(getServletContext().getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String[] values = req.getParameterValues("class");

        PrintWriter out = resp.getWriter();
        out.println(values);
    }
}
