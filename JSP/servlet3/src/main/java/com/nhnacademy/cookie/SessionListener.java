package com.nhnacademy.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class SessionListener implements HttpSessionListener {
    private int sessionCount = 0;
    @Override
    // req.getSession 하면 불려짐
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        log.error("Session count={}", sessionCount);
    }

    @Override
    // req.invalidate() 하면 불려짐
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount --;
        log.error("Session count={}", sessionCount);
    }
}
