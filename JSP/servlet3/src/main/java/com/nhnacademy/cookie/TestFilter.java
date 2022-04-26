package com.nhnacademy.cookie;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        // 실제 servlet 실행 전 실행
        log.error("TestFilter doFilter before");

        // doFilter에서는 이것을 무조건 해야한다
        // 이것을 하지 않으면 브라우저에서 온 요청을 필터가 가지고 멈춰서 servlet까지 요청이 가지 않음
        filterChain.doFilter(servletRequest, servletResponse);
        log.error("TestFilter doFilter after");
    }

}
