package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloServlet extends HttpServlet {
    String title;
    String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // super.doGet(req, resp); // 이거는 보통 지워야한다. 메세지가 나가지 않으면 405 뜨게 되어있어서

//        String title2 = getServletConfig().getInitParameter("title");
//        이런식으로 받아와도 된다

//        getServletContext().getMajorVersion();

        CounterUtils.increaseCounter(getServletContext());
        try (PrintWriter out = resp.getWriter()) {
            out.println("Hello, Servlet, " + title + name);

            out.println(getServletContext().getInitParameter("url"));

            out.println(getServletContext().getAttribute("counter"));
        } catch (IOException e) {
            log.error("", e);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.error("init() called");
        super.init(config);

        title = config.getInitParameter("title");
        name = config.getInitParameter("name");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.error("service() called");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.error("destroy() called");
        super.destroy();
    }
}
