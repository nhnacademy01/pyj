package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

//        Enumeration<String> foods = getServletContext().getAttributeNames();

        out.print("onion: ");
        out.println(getServletContext().getAttribute("onion"));
        out.print("egg: ");
        out.println(getServletContext().getAttribute("egg"));
        out.print("welshOnion: ");
        out.println(getServletContext().getAttribute("welshOnion"));
        out.print("apple: ");
        out.println(getServletContext().getAttribute("apple"));


    }
}
