package com.nhnacademy.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name="fileDownloadServlet", urlPatterns = "/download")
@Slf4j
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        // 파일이 있는 위치에서
        // file io 이용해서
        // inputStream, outputStream 2개 쓰기
        // inputStream의 값이 없을 때까지(readMethod 호출했을 떄 -1까지) file 읽기
    }
}
