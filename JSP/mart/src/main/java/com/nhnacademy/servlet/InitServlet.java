package com.nhnacademy.servlet;

import com.nhnacademy.mart.Food;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("Preparing Food Stand");

        for (int i = 0; i < 2; i++) {
            addStand(getServletContext(), "onion", new Food("onion", Integer.parseInt(getServletContext().getInitParameter("onion"))));
        }
        for (int i = 0; i < 5; i++) {
            addStand(getServletContext(), "egg", new Food("egg", Integer.parseInt(getServletContext().getInitParameter("egg"))));
        }
        for (int i = 0; i < 10; i++) {
            addStand(getServletContext(), "welshOnion", new Food("welshOnion", Integer.parseInt(getServletContext().getInitParameter("welshOnion"))));
        }
        for (int i = 0; i < 20; i++) {
            addStand(getServletContext(), "apple", new Food("apple", Integer.parseInt(getServletContext().getInitParameter("apple"))));
        }

        resp.sendRedirect("food.html");

    }

    public static void addStand(ServletContext servletContext, String name, Food food){
        servletContext.setAttribute(name, food.getPrice());
    }
}
