public class WhoIsHong {
    public static void main(String[] args) {
        String label = "name";
        switch (label) {
            case "name":
                System.out.println("홍길동");
                break;
            case "nickname":
                System.out.println("의적");
                break;
            case "organization":
                System.out.println("활빈당");
                break;
            default:
                System.out.println("출력할 수 없는 입력값이에요");
        }

        WhoIsHong wih = new WhoIsHong();
        wih.print(61);
    }

    public void print(int score){
        int checkScore = score / 10;

        switch (checkScore){
            case 10:
                System.out.println("A");
                break;
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
        }
    }
}
