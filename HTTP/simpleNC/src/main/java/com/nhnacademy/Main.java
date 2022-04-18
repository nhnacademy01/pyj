package com.nhnacademy;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("server start");
            Socket sock = new Socket("133.186.213.240", 8888);
            InputStream in = sock.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            sock.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

}
