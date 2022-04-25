package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NowServlet extends HttpServlet {
    LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.error("NowServlet service() called");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.error("NowServlet destroy() called");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.error("NowServlet init() called");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        CounterUtils.increaseCounter(getServletContext());

        PrintWriter out = resp.getWriter();
        log.error("NowServlet doGet() start");
        out.println(localDateTime);
    }
}
