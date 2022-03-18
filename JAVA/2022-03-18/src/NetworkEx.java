import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnknownHostException;
import java.rmi.activation.UnknownGroupException;
import java.util.Arrays;

public class NetworkEx {
    public static void main(String[] args) throws Exception {
        NetworkEx networkEx = new NetworkEx();
//        networkEx.netWorkEx();
//        networkEx.urlEx();
        networkEx.fileDownload();
    }

    private void netWorkEx() throws Exception {
        InetAddress ip = InetAddress.getByName("www.nhnacademy.com");
        System.out.println(ip);
        System.out.println("hostName: " + ip.getHostName());
        System.out.println("hostAddress: " + ip.getHostAddress());
        System.out.println("canonicalHostName: " + ip.getCanonicalHostName());

        InetAddress[] paycoIps = InetAddress.getAllByName("amazon.com");
        // 아마존 이름으로 등록된 도메인이 여러개여서
        // 출력이
        // [amazon.com/54.239.28.85, amazon.com/176.32.103.205, amazon.com/205.251.242.103]
        System.out.println(Arrays.toString(paycoIps));

        InetAddress localIp = InetAddress.getLocalHost();
        System.out.println(localIp);
        System.out.println("hostName: " + localIp.getHostName());
        System.out.println("hostAddress: " + localIp.getHostAddress());
        System.out.println("canonicalHostName: " + localIp.getCanonicalHostName());
    }

    private void urlEx() throws Exception {
        URL url = new URL("https://nhnacademy.com/");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            // open stream 하면 url에 있는 정보 싹 가져온다
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void fileDownload() throws Exception {
        URL url = new URL("https://nhn.com/ci/NHN_CI.zip");
        try (BufferedInputStream input = new BufferedInputStream(url.openStream());
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("nhnci.zip"))) {
            byte[] buf = new byte[1024];
            int byteSize = 0;
            while ((byteSize = input.read(buf)) > -1) {
                // TODO
                output.write(buf, 0, byteSize);
                // 버퍼가 잘 쌓여있으면 (1024) write를 하는데 문제가 없는데
                // 버퍼가 잘 쌓여있지 않으면 (1024 이하) 0~n 까지 읽을꺼야! 라는 뜻~
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
