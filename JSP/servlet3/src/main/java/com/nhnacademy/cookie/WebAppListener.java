package com.nhnacademy.cookie;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class WebAppListener implements ServletContextListener {
    // servletcontext가 초기화되거나 파괴될 때만 사용됨
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = "/WEB-INF/classes/" + servletContext.getInitParameter("counterFileName");

        Integer counter = null;
        try (DataInputStream dis = new DataInputStream(
            servletContext.getResourceAsStream(counterFileName))) {
            counter = dis.readInt();
        } catch (IOException e) {
            log.error("", e);
        }

        int count = Optional.ofNullable(counter).orElse(0);

        servletContext.setAttribute("counter", count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        int counter = (int) servletContext.getAttribute("counter");

        String counterFileName = "/WEB-INF/classes/" + servletContext.getInitParameter("counterFileName");

//        URL url = servletContext.getResource(counterFileName);

//        File file = new File(url.toURI());
//        FileOutputStream fos = new FileOutputStream(file);
//        DataOutputStream dos = new DataOutputStream(fos);

//       -->  Files.newInputStream(Paths.get(url.toURI()))

        try (OutputStream fos = Files.newOutputStream(
            Paths.get(servletContext.getResource(counterFileName).toURI()));
             DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeInt(counter);

        } catch (IOException | URISyntaxException ex) {
            log.error("", ex);
        }

        // 이거를 줄여서 위에처럼 씀
//        try {
//            URL url = servletContext.getResource(counterFileName);
//            File file = new File(url.toURI());
//            FileOutputStream fos = new FileOutputStream(file);
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeInt(counter);
//
//        }catch (MalformedURLException e){
//            log.error("",e);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
