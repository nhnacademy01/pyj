package game;

// <출력>
// 03:29:19 Start server 0.0.0.0/0.0.0.0:8888
// 이렇게 뜨면 서버가 돌아가는 것

// 서버 띄워둔 상태에서

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * 기능 모두 구현하기
 * 예외처리들
 * <p>
 * 클라이언트
 * - 물약 -> 상점, 돈, 몬스터 잡았을 때 돈
 * 상점
 * <p>
 * UI
 */

public class MyGameServer {
    // clientId: 클라이언트 전송(출력)용 OutputStream ((공유자원임 -> 그래서 concurrency 자원으로 만든 것이다))
    // hashmap 에 클라이언트 id를 키로 가지고 클라이언트에게 전송하는 메세지 저장용 hashmap
    // concurrency 자료구조는 멀티스레드 상에서 safe 하다
    // 공유자원임 --> concurrency는 동시성 이슈를 처리한 자료구조
    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap();

    private Character character = new Hero();
    private final List<Monsters> monsterList = Arrays.asList(new Slimes(), new Orcs(), new Dragons());

    public static void main(String[] args) throws IOException {
        MyGameServer server = new MyGameServer();
        server.start();

    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            // 서버 소켓은 열려져있는거고 클라이언트 소캣을 받을 수 있다
            // 8888 번을 열어두는 것이다
            // 내 ip 주소가 서버 주소가 된다
            // 즉 내 장비 ip + 8888 로 열리는 것이다

            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    // 클라이언트와 연결될 수 잇는 소켓 만들기
                    ClientSession client = new ClientSession(socket);
                    // 클라이언트 만들기
                    // 클라이언트 계속 유지되니까 client session임 (스레드)
                    client.start();
                } catch (IOException e) {
                    // TODO 클라이언트 접속 실패

                    // 예외 알아서 잘 만들어라~
                    // 예외 상황은 생각보다 많이 없다
                }
            }
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        // 시,분,초 출력
    }

    private void joinGame(ClientSession session) {
        clientOutMap.put(session.id, session.out);
        // hashmap 에 클라이언트 id를 키로 가지고 클라이언트에게 전송하는 메세지 저장용 hashmap

        sendToAll("[System] " + session.id + "님이 게임에 접속했습니다.");
        // 모든 사람에게 메세지를 보낸는 메소드
        System.out.println(getTime() + " " + session.id + " is joined: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
        // // 지금 클라이언트가 몇 명인지 찍어주는 것
    }

    private void leaveGame(ClientSession session) {
        clientOutMap.remove(session.id);
        // 클라이언트 지우고

        sendToAll("[System] " + session.id + "님이 게임을 나갔습니다.");
        // 누구 나갔다고 찍어주기
        System.out.println(getTime() + " " + session.id + " is leaved: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void loggingCurrentClientCount() {
        // 지금 클라이언트가 몇 명인지 찍어주는 것
        System.out.println(getTime() + " Currently " + clientOutMap.size() + " clients are connected.");
    }

    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }

    private void sendToClient(StringBuffer stringBuffer) throws IOException {
        for (DataOutputStream out : clientOutMap.values()) {
            for (int i = 0; i < stringBuffer.length(); i++) {
                try {
                    out.writeUTF(stringBuffer.toString());
                } catch (IOException e) {
                    // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
                }

            }
        }
    }


    class ClientSession extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;
        private String id; // 채팅을 하기 위한 사용자 id

        ClientSession(Socket socket) throws IOException {
            // 새로운 클라이언트가 접속할 때마다 스레드가 하나씩 만들어지는 것
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            // inputStream이 꾸며주기 쉽다
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() { // 스레드가 만들어주는 순ㄱ나 내부적으로 run
            initialize();
            // TODO
//            enterClient(); // 용 읽기

//            try {
//                sendToAll(readDragonFile());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            sendToAll(startGame(this.id));

            String clientAnswer = getClientAnswer();

            while (clientAnswer.equals("1")) {
                enterStage(character.getStageLevel());
                clientAnswer = getClientAnswer();
                doitGame(character.getStageLevel());
            }
            // 초기확
            connect();
        }

        private void initialize() {
            try {
                this.id = in.readUTF(); // 클라이언트가 맨 처음에 보내준 문자열을 id로 설정하겟다
                joinGame(this); // 채팅에 참여
                // MyChatSERVER.THIS에 있는 채팅으로 참여
                // 이게 왜 가능하냐면 클라이언트 세션이 내부 클래스여서 (nested)

            } catch (IOException cause) {
                // TODO: 최초 통신(아이디 받기)이 실패하는 경우
            }
        }

        private void connect() {
            // 연결이 되었는지 확인
            try {

                while (isConnect()) {
                    // 연결이 유지되고 있는지 확인
                    sendToAll(in.readUTF());

                    // 사용자가 ouputStream으로 보내면 전체에게 보내짐
                }
            } catch (IOException cause) {
                // TODO: 채팅 중 연결이 끊기는 경우

                //여기도 구현
            } finally {
                disconnect();
                // 접속이 끊기면 자원 해제
            }
        }

        private boolean isConnect() {
            return this.in != null;
            // input Stream이 null이 아니면 아직 지속중이구낭
        }

        private void disconnect() {
            leaveGame(this);
            // 채팅을 떠나는 작업
        }

        private void enterClient() throws IOException {
            sendToAll(readDragonFile());
            // FIXME : 드래곤 요상하게 읽힘
        }


        private String readDragonFile() throws IOException {
//            Path path = Paths.get("C:\\Users\\park\\Desktop\\NHN\\NHN_SRC\\JAVA\\2022-03-18\\src\\game\\dragon.txt");
//            Stream<Path> fileStream = Files.list(path);
//            return fileStream.flatMap(this::getLines); // static이 아닌 경우
//                    .forEach(System.out::println);

            String dragonTxt = "";
            try (FileInputStream in2 = new FileInputStream("dragon.txt")) {
                int c;

                while ((c = in2.read()) != -1) {  // 파일을 읽을 수 없을 때 -1 (EOF)
                    dragonTxt += in2.read();
                }
            } catch (Exception e) {
                System.out.println("드래곤이 없져요 ㅠㅠ");
                e.printStackTrace();
            }
            return dragonTxt;

        }

//        private Stream<String> getLines(Path f) {
//            try {
//                return Files.lines(f);
//            } catch (IOException e) {
//                return Stream.empty();
//            }
//        }

        private String startGame(String id) {
            String message = "용사 %d님 던전에 있는 드래곤을 물리쳐주세요!!! \\n";
            message += "1. 던전으로 들어간다. \\n";
            message += "2. 도망간다. (게임 종료) \\n";

            return message;
        }

        private String getClientAnswer() {
            String result = "";
            try {
                int index = in.readUTF().length();
                result = in.readUTF().substring(index - 1, index);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        private String enterStage(int playerStageLevel) {
            // TODO string buffer로 해보기
            String message = monsterList.get(playerStageLevel).getState() + " " + monsterList.get(playerStageLevel).getId() + "이 나타났다";
            message += "1. 던전으로 들어간다. %n";
            message += "2. 도망간다. (게임 종료) %n";

            return message;
        }

        private void doitGame(int playerStageLevel) {
            while(true){
                playerAttack
            }
            // 게임 시작

            // 사용자 공격
            // 몬스터 공격
            // 반복 -> 체력 달 때까지

            // 그리고 사용자 승리하면 -> 레벨업
            // 사용자 지면 -> lose

        }

        private void playerAttack(int playerStageLevel) {
            character.attack();
            monsterList.get(playerStageLevel).attacked()
        }

        private void monsterAttack(int playerStageLevel) {
            monsterList.get(playerStageLevel).attack();

        }


        private String winGame() {
            // TODO string buffer로 해보기
            String message = "용사 %d님 던전에 있는 드래곤을 물리쳐주세요!!! %n";
            message += "1. 던전으로 들어간다. %n";
            message += "2. 도망간다. (게임 종료) %n";
            Slime slime = new Slime();

            return message;
        }

        private String loseGame() {
            // TODO string buffer로 해보기
            String message = "용사 %d님 던전에 있는 드래곤을 물리쳐주세요!!! %n";
            message += "1. 던전으로 들어간다. %n";
            message += "2. 도망간다. (게임 종료) %n";
            Slime slime = new Slime();

            return message;
        }

        private void gamePlay() {

        }
    }


    private static class Senders extends Thread {
        private String id;
        private DataOutputStream out;

        private Senders(Socket socket, String id) throws IOException {
            this.id = id;
            this.out = new DataOutputStream(socket.getOutputStream());
            // 나는 센더니까 (메세지를 출력할거니가) outputStream
        }

        @Override
        public void run() {
            try {
                sendMessage();
                //
            } catch (IOException e) {
                // TODO
            }
        }


        private boolean isSendable() {
            return this.out != null;
            // output stream이 아직 유효하냐
        }


        private void sendMessage() throws IOException { // 다른 클라이언트에게 메세지 보내는 것
            try (Scanner scanner = new Scanner(System.in)) {
                // 스캐너에서 입력받은 문자열 출력 받을 수 있따
                while (isSendable()) {  // output stream이 아직 유효하면
                    this.out.writeUTF("[" + id + "] " + scanner.nextLine());
                    // 내가 이렇게 말햇어 라고 지정
                    // 서버에 이것을 출력
                }
            }
        }

        private void startGame(String id) throws IOException {
            // 용사 {id}님 던전에 있는 드래곤을 물리쳐주세요!!!
            //1. 던전으로 들어간다.
            //2. 도망간다. (게임 종료)
            System.out.printf("용사 %d님 던전에 있는 드래곤을 물리쳐주세요!!!", id);
            System.out.println("1. 던전으로 들어간다.");
            System.out.println("2. 도망간다. (게임 종료)");
            try (Scanner scanner = new Scanner(System.in)) {
                if (scanner.nextInt() == 1) {
                    System.out.printf("용사 %d님 던전 들어가기를 선택하셨습니다", id);
                    this.out.writeUTF("[" + id + "] " + scanner.nextLine());
                } else if (scanner.nextInt() == 2) {
                    System.out.printf("용사 %d님은 도망가기를 선택하셨습니다.", id);
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