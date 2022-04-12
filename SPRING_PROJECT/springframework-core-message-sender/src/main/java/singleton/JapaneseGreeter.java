package singleton;

public class JapaneseGreeter {
    // 싱글톤은 시스템 내에서 객체를 딱 1개만 사용할 수 있도록 하는 것
    // -> new 를 못하게 하는 것
    // 코드로 제약을 시켜놓는 것

    private static JapaneseGreeter INSTANCE = new JapaneseGreeter();

    private JapaneseGreeter() {

    }

    public static JapaneseGreeter getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        JapaneseGreeter.getInstance();
    }
}

