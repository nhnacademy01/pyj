package game;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyGameServer {
    private final ConcurrentHashMap<ClientSession, ConcurrentHashMap> clientMap = new ConcurrentHashMap<>(); // < session, clientOutMap>
    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap(); // id string

    private static Hero hero = new Hero();
    private static List<Character> monsterList = Arrays.asList(null, new Slime(), new Orc(), new Dragon());


    public static void main(String[] args) throws IOException {
        MyGameServer server = new MyGameServer();
        server.start();
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    ClientSession client = new ClientSession(socket);
                    client.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    private void joinGame(ClientSession session) {
        clientOutMap.put(session.id, session.out);
        hero.setId(session.id);

        System.out.println(getTime() + " " + session.id + " is joined: " + session.socket.getInetAddress());
        sendToAll("[System] " + session.id + "님이 게임에 접속했습니다.");

        loggingCurrentClientCount();
    }

    private void leaveGame(ClientSession session) {
        clientMap.remove(session.id);
        clientOutMap.remove(session.id);
        sendToAll("[System] " + session.id + "님이 게임을 종료했습니다.");
        System.out.println(getTime() + " " + session.id + " is leaved: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void loggingCurrentClientCount() {
        System.out.println(getTime() + " Currently " + clientOutMap.size() + " clients are connected.");
    }

    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    class ClientSession extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;
        private String id;



        ClientSession(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() throws StringIndexOutOfBoundsException {
            initialize();

            try{
                connect();
                enterClient();
            }catch (Exception e){
                e.printStackTrace();
            }


        }

        private void startEnterGame(){
            sendToClient(startGame(this.id));
            sendToClient("game start");
            String clientAnswer = getClientAnswer();

            while(clientAnswer.equals("1")) {
                try {
                    sendToClient(enterGameStage(monsterState()));
                    clientAnswer = getClientAnswer();
                    if(clientAnswer.equals("2")){
                        disconnect();
                        break;
                    }
                    clientAnswer = Integer.toString(doitGame());
                    checkTopLevel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }disconnect();
        }

        private void sendToClient(String msg) {
            try {
                out.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void checkTopLevel(){
            if (hero.getLevel() >= 4) {
                sendToAll("[외침] " + hero.getId() + "가 드래곤을 물리쳤다 !");
            }
        }


        private void initialize() {
            try {
                this.id = in.readUTF();
                joinGame(this);

            } catch (IOException cause) {
                cause.printStackTrace();
            }
        }

        private void connect() {
            sendToClient("                 ___====-_  _-====___\n" +
                    "           _--^^^#####//      \\\\#####^^^--_\n" +
                    "        _-^##########// (    ) \\\\##########^-_\n" +
                    "       -############//  |\\^^/|  \\\\############-\n" +
                    "     _/############//   (@::@)   \\\\############\\_\n" +
                    "    /#############((     \\\\//     ))#############\\\n" +
                    "   -###############\\\\    (oo)    //###############-\n" +
                    "  -#################\\\\  / VV \\  //#################-\n" +
                    " -###################\\\\/      \\//###################-\n" +
                    "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                    "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                    "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                    "   `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                    "                    (  | |  | |  )\n" +
                    "                   __\\ | |  | | /__\n" +
                    "                  (vvv(VVV)(VVV)vvv)\n" +
                    "\n" +
                    "-- 계속 할려면 엔터를 입력해주세요. --");
            try {
                while (isConnect()) {
                    String test = in.readUTF();
                    if(test.equals("")) {
                        startEnterGame();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }

        private boolean isConnect() {
            return this.in != null;
        }

        private void disconnect() {
            leaveGame(this);
        }

        private void enterClient() throws DragonFileException {
//            sendToClient(clientMap, readDragonFile());
        }


//        private String readDragonFile() {
//            String dragonTxt = "";
//            File file = new File("src\\dragon.txt");
//            try (FileInputStream in = new FileInputStream(file)) {
//                byte[] bytes = new byte[1024];
//
//                while (in.read(bytes) != -1) {
//                    dragonTxt += new String(bytes);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return dragonTxt;
//        }


        private String startGame(String id) {
            String message = String.format("용사 %s님 던전에 있는 드래곤을 물리쳐주세요!!! %n", id);
            message += String.format("1. 던전으로 들어간다. %n");
            message += String.format("2. 도망간다. (게임 종료) %n");
            return message;
        }

        private String getClientAnswer() {
            String result = "";
            try {
                result = in.readUTF();

                if (result.equals("2")) {
                    disconnect();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }


        private String enterGameStage(String monsterState) {
            String message = String.format("%s가 나타났다 %n", monsterState);
            message += String.format("1. 공격 %n");
            message += String.format("2. 도망간다. (게임 종료) %n");
            return message;
        }

        private int doitGame() throws InterruptedException {
            sendToClient("초기 상태");
            showCharacterState(hero);
            showCharacterState(getMonster(hero.getLevel()));
            return attack();
        }


        private int attack() throws InterruptedException {
            Character winCharacter = null;
            while (hero.getHp() > 0 && (getMonster(hero.getLevel()).getHp() > 0)) {
                userAttack();
                showCharacterState(hero);
                monsterAttack();
                showCharacterState(getMonster(hero.getLevel()));
                winCharacter = checkHp();
            }

            return checkWinner(winCharacter);
        }

        private Character checkHp() {
            Character winCharacter = hero;
            if ((hero.getHp() < 0)) {
                winCharacter = getMonster(hero.getLevel());
            } else if ((getMonster(hero.getLevel()).getHp() < 0)) {
                winCharacter = hero;
            }
            return winCharacter;
        }

        private void userAttack() throws InterruptedException {
            getMonster(hero.getLevel()).attacked(hero.attack());
            Thread.sleep(500);

        }

        private void monsterAttack() throws InterruptedException {
            hero.attacked(getMonster(hero.getLevel()).attack());
            Thread.sleep(500);

        }

        private int checkWinner(Character winCharacter) {
            int result = 1;
            if (winCharacter.equals(hero)) {
                levelUp();
            } else {
                sendToClient(winGame(monsterState()));
                sendToClient(loseGame(hero.getId()));
                result = 0;
            }
            return result;
        }


        private void showCharacterState(Character character) {
            sendToClient(character.toString());

        }

        private String winGame(String id) {
            String message = String.format("%s 님의 승리입니다 %n", id);
            message += String.format("레벨 %d로 상승했다 %n", hero.getLevel());
            return message;
        }

        private String loseGame(String id) {
            String message = String.format("%s님의 패배입니다 %n", id);
            return message;
        }

        private void levelUp() {
            hero.levelUp();
        }

        private String monsterState() {
            return getMonster(hero.getLevel()).getState() + getMonster(hero.getLevel()).getId();
        }

        private Character getMonster(int index) {
            return monsterList.get(index);
        }
    }

}