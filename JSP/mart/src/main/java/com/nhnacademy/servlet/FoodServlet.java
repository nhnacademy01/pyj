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


        // CartServlet  쪽


        ////////////////////////////////////////////////////////////////
        // 현재 상품 목록이 나오면서 form에 담겨서 수량도 입력할 수 있게
//        out.pringln("<form method="post" action="/cart>")
//        FoodStand foodStand = getServletContext().getAttribute("foodstand");
//        List<Item> items = foodStand.getItems();
//        for(Item item : items){
//            out.println("<div>")
//            out.println("<input type="checkbox" name="food" value="apple">")
//                상품명
//                    가격
        // 수량 -> checkbox 옆에 textbox 만들어서 그거 가져오는 방향으로
//                    수량 "<input type="checkbox" name="" value="">"
//            out.println("<li>" + item.getName() + ", ");
//            out.println("</div>")
//        }
//
//        out.pringln("<input type="submit" value="장바구니 담기">");
//        out.pringln("</form>")



    }
}
