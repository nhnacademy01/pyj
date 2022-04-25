package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

public class HtmlServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String html = req.getParameter("html");

        resp.setContentType("text/plain"); //html로 랜더링 안되고 text 모양 그대로 보여준다
        PrintWriter out = resp.getWriter();
        out.println(Jsoup.parse(html).toString());

    }
}
