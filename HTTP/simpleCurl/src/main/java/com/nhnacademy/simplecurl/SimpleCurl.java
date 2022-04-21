package com.nhnacademy.simplecurl;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;
import org.json.simple.JSONObject;


public class SimpleCurl {
    public static void main(String[] args) throws IOException {
        final DataInputStream in;
        final PrintStream out;

        ParseUrl parseUrl = new ParseUrl();
        parseUrl.parseUrl(args);

        try (Socket serverSocket = new Socket(parseUrl.getHost(), parseUrl.getPort())) {
            System.out.println("Start server " + serverSocket.getLocalSocketAddress());

            in = new DataInputStream(serverSocket.getInputStream()); // 서버로 들어옴
            out = new PrintStream(serverSocket.getOutputStream()); // 서버에서 나감

            if (args[0].equals("-v")) {
                // Ex 4
                if (args[1].equals("-H")) {
                    String header = args[2];
                    writeCli(out, parseUrl);
                    out.println(header);
                }

                // Ex 5
                if (args[1].equals("-X") && args[2].equals("POST")) { // Ex 5
                    writeCliPost(out, parseUrl, args);
                }
            } else if (args[0].equals("-L")) {
                writeCliLocation(out, parseUrl, args);
            } else if (args[0].equals("-F")) {
                writeCliFile(out, parseUrl);
            } else {
                writeCli(out, parseUrl);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String str;
            boolean isChecked = false;

            while ((str = reader.readLine()) != null) {
                byte[] data = new byte[str.length()];
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) str.charAt(i);
                }

                // Ex 1
                if (args.length == 1) {
                    if (str.equals("")) {
                        isChecked = true;
                    }
                    if (isChecked) {
                        in.readFully(data);
                    }
                }

                if (args[0].equals("-X")) { // Ex 2
                    if (str.equals("")) {
                        isChecked = true;
                    }
                    if (isChecked) {
                        in.readFully(data);
                    }
                }

                if (args[0].equals("-v")) {// Ex 3
                    if (args[1].equals("-H")) {// Ex 4
                        in.readFully(data);

                    }
                    if (args[1].equals("-X") && args[2].equals("POST")) {// Ex 5
                        in.readFully(data);
                    }
                }

                if (args[0].equals("-L")) { // Ex 6
                    int count = 0;
                    while (count < 5) {
                        if (str.contains("location:")) {
                            String location =
                                str.split("location:")[1].split("Access-Control-Allow-Origin")[0];
                            count = writeCliLocationCount(out, parseUrl, location, count);
                        } else {
                            in.readFully(data);
                            break;
                        }
                    }
                }

                if (args[0].equals("-F")) { // Ex 7
                    in.readFully(data);
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void writeCli(PrintStream out, ParseUrl parseUrl) {
        out.println("GET /get HTTP/1.1");
        out.println("Host: " + parseUrl.getHost());
        out.println("User-Agent: curl/7.68.0");
        out.println("Accept: */*");
        out.println("\n");
        out.flush();
    }

    public static void writeCliPost(PrintStream out, ParseUrl parseUrl, String[] args) {
        List<String> result = parseJson(args[4]);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(result.get(0), result.get(1));

        out.println("POST /post HTTP/1.1");
        out.println("Host: " + parseUrl.getHost());
        out.println("User-Agent: curl/7.68.0");
        out.println("Accept: */*");
        out.println(args[6]);
        out.println("Content-Length: 20");
        out.println("\n");
        out.println(new Gson().toJson(jsonObject));
        out.println("\n");
        out.flush();
    }

    public static void writeCliLocation(PrintStream out, ParseUrl parseUrl, String[] args) {
        String status = args[1].split("org")[1];
        out.println("GET " + status + " HTTP/1.1");
        out.println("Host: " + parseUrl.getHost());
        out.println("User-Agent: curl/7.68.0");
        out.println("Accept: */*");
        out.println("\n");
        out.flush();
    }

    public static int writeCliLocationCount(PrintStream out, ParseUrl parseUrl, String location,
                                            int count) {
        out.println("GET " + location + " HTTP/1.1");
        out.println("Host: " + parseUrl.getHost());
        out.println("User-Agent: curl/7.68.0");
        out.println("Accept: */*");
        out.println("\n");
        out.flush();
        count += 1;
        return count;
    }

    public static void writeCliFile(PrintStream out, ParseUrl parseUrl) {
        out.println("POST /post HTTP/1.1");
        out.println("Host: " + parseUrl.getHost());
        out.println("User-Agent: curl/7.68.0");
        out.println("Accept: */*");
        out.println("Content-Length: 9999");
        out.println("\n");
        out.println("Content-Disposition: form-data; name=files; filename=test1.txt[\r][\n]");
        out.println("Content-type=multipart/formdata; boundary=----myboundary");
        out.println("\n");
        out.flush();
    }

    public static List<String> parseJson(String json) {
        List<String> result = new ArrayList<>();
        result.add((json.split(":")[0]).replaceAll("[^a-zA-Z]", ""));
        result.add((json.split(":")[1]).replaceAll("[^a-zA-Z]", ""));
        return result;
    }


}
