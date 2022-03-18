package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// 결산과제는 게임서버, 클라이언트 구현


// alt shitf f10
// my chat client
// 오른쪽 방향기
// edit 클릭
// MULTIPLE INSTANCE 뭐쩌구..

// 그리고 ARGUMENTS에 사용할 ID 추가
public class MyChatClient {
    // 채팅 사용자들이 사용하는 프로그램
    private final String id;
    // id를 내부에 인스턴스 변수로 지정

    public MyChatClient(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        if (hasNotArgs(args)) {  // id를 받을 수 있는 코드
            // 인자를 받을 수 있음
            // 인자가 없으면 실행이 안됨 (id)
            System.out.println("USAGE: java MyChatClient {id}");
            return;
        }
        String id = args[0];
        MyChatClient client = new MyChatClient(id);

        client.connect("192.168.71.47", 8888);
        // 서버에 커넥트
        // ip는 나자신, 포트는 아까 열었떤 8888

    }

    private static boolean hasNotArgs(String[] args) {
        return args.length == 0;
    }

    private void connect(String serverHost, int port) {
        // 서버 호스트랑 포트를 받아서 소켓을 만듬
        try { // 소켓을 만든다
            // 이거는 클라이언트가 만든 소켓
            Socket socket = new Socket(serverHost, port);
            // 소켓을 만든 순간 커넥트 된 것임
            System.out.println("Connected to server " + serverHost + ":" + port);
            Thread sender = new Sender(socket, id);
            // 메세지를 주는 스레드
            Thread receiver = new Receiver(socket);
            // 메세지를 받는 스레드
            // 내가 채팅서버에 메세지 보낼거 하나(센더), 내가 채팅서버에서 메세지 받을것 하나

            sender.start();
            receiver.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Sender extends Thread {
        private String id;
        private DataOutputStream out;

        private Sender(Socket socket, String id) throws IOException {
            this.id = id;
            this.out = new DataOutputStream(socket.getOutputStream());
            // 나는 센더니까 (메세지를 출력할거니가) outputStream
        }

        @Override
        public void run() {
            try {
                initialize();
                // 초기화
                sendMessage();
                //
            } catch (IOException e) {
                // TODO
            }
        }

        private void initialize() throws IOException {
            if (isSendable()) {
                // 맨 처음에 서버 아이디를 보낸다
                this.out.writeUTF(id);
            }
        }

        private boolean isSendable() {
            return this.out != null;
            // output stream이 아직 유효하냐
        }

        private void sendMessage() throws IOException {
            try (Scanner scanner = new Scanner(System.in)) {
                // 스캐너에서 입력받은 문자열 출력 받을 수 있따
                while (isSendable()) {  // output stream이 아직 유효하면
                    this.out.writeUTF("[" + id + "] " + scanner.nextLine());
                    // 내가 이렇게 말햇어 라고 지정
                    // 서버에 이것을 출력
                }
            }
        }
    }

    private static class Receiver extends Thread {
        private final DataInputStream in;

        private Receiver(Socket socket) throws IOException {
            this.in = new DataInputStream(socket.getInputStream());
            // 소켓에서 inputstream 받아서 초기화
        }

        @Override
        public void run() {
            while (isReceivable()) { // 받을 수 잇는지 확인
                receiveMessage();
            }
        }

        private boolean isReceivable() {
            return this.in != null;
        }

        private void receiveMessage() {
            try {
                System.out.println(in.readUTF()); // 서버가 주는 메세지 출력
            } catch (IOException e) {
                // TODO
            }
        }
    }
}