package com.nhnacademy.servlet;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "loginServlet", urlPatterns = "/login",
initParams = {
    @WebInitParam(name="id", value="pyj"),
    @WebInitParam(name="pwd", value="123")
})
@Slf4j
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        configId = config.getInitParameter("id");
        configPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(Objects.isNull(session)){
            resp.sendRedirect("/loginForm.html");
        }else{
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("login success : " + session.getAttribute("id"));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if(id.equals(configId) && pwd.equals(configPwd)){
            HttpSession session = req.getSession(false);

            if(Objects.nonNull(session)){
                session.invalidate();
            }
            session = req.getSession(true);
            session.setAttribute("id", id);

            resp.sendRedirect("/login");
        }else{
            resp.sendRedirect(".loginForm.html");
        }
    }
}
