package com.nhnacademy.cookie;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name="loginServlet", urlPatterns = "/login", initParams = {
    @WebInitParam(name="id", value = "aaa"),
    @WebInitParam(name="pwd", value = "aaa")
})
@Slf4j
public class LoginServlet extends HttpServlet {
    String configId;
    String configPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        configId = config.getInitParameter("id");
        configPwd = config.getInitParameter("pwd");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            // Objects.isNull(session.getAttribute("id")
            // 이 경우까지는 갈 필요가 없다
            // 왜냐하면 로그인 실패시 session 자체를 만들지 않았기 때문이다

//            resp.sendRedirect("/login.html");

            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);

        } else {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("login success");
            resp.getWriter().println(session.getAttribute("id"));
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if (id.equals(configId) && pwd.equals(configPwd)) {
            HttpSession session = req.getSession(false);

            // 기존에 세션 있으면 죽이고 새로 만들기
            if (Objects.nonNull(session)) {
                session.invalidate();
            }
            session = req.getSession(true);
            session.setAttribute("id", id);

            // request dispatcher는 요청을 공유하기 때문에
            // 여기서는 get으로 가는게 아니라 post 안에서 계속 돈다
            // -> 새로운 요청으로 공유해야하는 경우에는 request dispatcher 사용하지말고
            //      send redirect 사용해야한다
//            RequestDispatcher rd = req.getRequestDispatcher("/login");
//            rd.forward(req, resp);

            resp.sendRedirect("/login");

        } else {
            resp.sendRedirect("/login.html");
//            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
//            rd.forward(req, resp);
        }

    }
}
