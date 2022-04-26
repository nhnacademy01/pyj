package com.nhnacademy.cookie;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name="fileUploadServlet", urlPatterns = "/upload")
@Slf4j
@MultipartConfig(
    location = "C:/Users/park/", // 임시 저장소
    maxFileSize = -1L,
    maxRequestSize = -1L,
    fileSizeThreshold = 1024
)
public class FileUploadServlet extends HttpServlet {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "C:/Users/park/Desktop/NHN/NHN_SRC/JSP/file";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        for (Part part : req.getParts()) {
            String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

            if (contentDisposition.contains("filename=")) {
                String fileName = extractFileName(contentDisposition);

                if (part.getSize() > 0) {
                    part.write(UPLOAD_DIR + File.separator + fileName);
                    part.delete();
                    // 임시 저장소에 저장되었던 part (MultipartConfig (location) 임시저장소)
                }
            } else {
                String formValue = req.getParameter(part.getName());
                log.error("{}={}", part.getName(), formValue);
            }
        }
    }

    private String extractFileName(String contentDisposition) {
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                int index = fileName.lastIndexOf(File.separator);
                return fileName.substring(index + 1);
            }
        }
        return null;
    }
}
