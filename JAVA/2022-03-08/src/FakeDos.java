import java.util.Scanner;

public class FakeDos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do{
            System.out.print("> ");
            command = scanner.next();
//            System.out.println(command + " 명령어를 실행했습니다.");

            if (command.equals("dir")){
                System.out.println("디렉토리 목록을 출력합니다");
            }else if(command.equals("cp")){
                System.out.println("파일을 복사합니다.");
            }else if(command.equals("quit")){
                System.out.println("(프로그램 종료)");
            } else{
                System.out.println("존재하지 않는 명령어입니다.");
            }

        }while(!command.equals("quit"));
    }
}
