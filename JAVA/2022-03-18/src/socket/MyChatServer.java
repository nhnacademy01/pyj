//package socket;
//
//// <출력>
//// 03:29:19 Start server 0.0.0.0/0.0.0.0:8888
//// 이렇게 뜨면 서버가 돌아가는 것
//
//// 서버 띄워둔 상태에서
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class MyChatServer {
//    // clientId: 클라이언트 전송(출력)용 OutputStream ((공유자원임 -> 그래서 concurrency 자원으로 만든 것이다))
//    // hashmap 에 클라이언트 id를 키로 가지고 클라이언트에게 전송하는 메세지 저장용 hashmap
//    // concurrency 자료구조는 멀티스레드 상에서 safe 하다
//    // 공유자원임 --> concurrency는 동시성 이슈를 처리한 자료구조
//    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap();
//
//
//    public static void main(String[] args) throws IOException {
//        MyChatServer server = new MyChatServer();
//        server.start();
//    }
//
//    public void start() throws IOException {
//        try (ServerSocket serverSocket = new ServerSocket(8888)) {
//            // 서버 소켓은 열려져있는거고 클라이언트 소캣을 받을 수 있다
//            // 8888 번을 열어두는 것이다
//            // 내 ip 주소가 서버 주소가 된다
//            // 즉 내 장비 ip + 8888 로 열리는 것이다
//
//            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
//            while (true) {
//                try {
//                    Socket socket = serverSocket.accept();
//                    // 클라이언트와 연결될 수 잇는 소켓 만들기
//                    ClientSession client = new ClientSession(socket);
//                    // 클라이언트 만들기
//                    // 클라이언트 계속 유지되니까 client session임 (스레드)
//                    client.start();
//                } catch (IOException e) {
//                    // TODO 클라이언트 접속 실패
//
//                    // 예외 알아서 잘 만들어라~
//                    // 예외 상황은 생각보다 많이 없다
//                }
//            }
//        }
//    }
//
//    private String getTime() {
//        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
//        // 시,분,초 출력
//    }
//
//    private void joinChat(ClientSession session) {
//        clientOutMap.put(session.id, session.out);
//        // hashmap 에 클라이언트 id를 키로 가지고 클라이언트에게 전송하는 메세지 저장용 hashmap
//
//        sendToAll("[System] " + session.id + "님이 입장했습니다.");
//        // 모든 사람에게 메세지를 보낸는 메소드
//        System.out.println(getTime() + " " + session.id + " is joined: " + session.socket.getInetAddress());
//        loggingCurrentClientCount();
//        // // 지금 클라이언트가 몇 명인지 찍어주는 것
//    }
//
//    private void leaveChat(ClientSession session) {
//        clientOutMap.remove(session.id);
//        // 클라이언트 지우고
//
//        sendToAll("[System] " + session.id + "님이 나갔습니다.");
//        // 누구 나갔다고 찍어주기
//        System.out.println(getTime() + " " + session.id + " is leaved: " + session.socket.getInetAddress());
//        loggingCurrentClientCount();
//    }
//
//    private void loggingCurrentClientCount() {
//        // 지금 클라이언트가 몇 명인지 찍어주는 것
//        System.out.println(getTime() + " Currently " + clientOutMap.size() + " clients are connected.");
//    }
//
//    private void sendToAll(String message) {
//        for (DataOutputStream out : clientOutMap.values()) {
//            try {
//                out.writeUTF(message);
//            } catch (IOException e) {
//                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
//            }
//        }
//    }
//
//    class ClientSession extends Thread {
//        private final Socket socket;
//        private final DataInputStream in;
//        private final DataOutputStream out;
//        private String id; // 채팅을 하기 위한 사용자 id
//
//        ClientSession(Socket socket) throws IOException {
//            // 새로운 클라이언트가 접속할 때마다 스레드가 하나씩 만들어지는 것
//            this.socket = socket;
//            this.in = new DataInputStream(socket.getInputStream());
//            // inputStream이 꾸며주기 쉽다
//            this.out = new DataOutputStream(socket.getOutputStream());
//        }
//
//        @Override
//        public void run() { // 스레드가 만들어주는 순ㄱ나 내부적으로 run
//            initialize();
//            // 초기확
//            connect();
//        }
//
//        private void initialize() {
//            try {
//                this.id = in.readUTF(); // 클라이언트가 맨 처음에 보내준 문자열을 id로 설정하겟다
//                joinChat(this); // 채팅에 참여
//                // MyChatSERVER.THIS에 있는 채팅으로 참여
//                // 이게 왜 가능하냐면 클라이언트 세션이 내부 클래스여서 (nested)
//            } catch (IOException cause) {
//                // TODO: 최초 통신(아이디 받기)이 실패하는 경우
//            }
//        }
//
//        private void connect() {
//            // 연결이 되었는지 확인
//            try {
//                while (isConnect()) {
//                    // 연결이 유지되고 있는지 확인
//                    sendToAll(in.readUTF());
//                    // 사용자가 ouputStream으로 보내면 전체에게 보내짐
//                }
//            } catch (IOException cause) {
//                // TODO: 채팅 중 연결이 끊기는 경우
//
//                //여기도 구현
//            } finally {
//                disconnect();
//                // 접속이 끊기면 자원 해제
//            }
//        }
//
//        private boolean isConnect() {
//            return this.in != null;
//            // input Stream이 null이 아니면 아직 지속중이구낭
//        }
//
//        private void disconnect() {
//            leaveChat(this);
//            // 채팅을 떠나는 작업
//        }
//    }
//}