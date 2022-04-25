package com.nhnacademy.servlet;

import com.nhnacademy.mart.BuyList;
import com.nhnacademy.mart.Food;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
    BuyList buyList = new BuyList();
    String[] cart = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        cart = req.getParameterValues("class");

        out.println("-- wanted to buy --");
        for (String str : cart) {
            out.println(str);
        }

        for (String food : cart) {
            buyList.add(new BuyList.Item(food, 1));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("-- buylist --");
        for (BuyList.Item item : buyList.getItems()) {
            out.println(item);
        }
    }
}

