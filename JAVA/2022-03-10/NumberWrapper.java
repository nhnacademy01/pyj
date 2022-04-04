public class NumberWrapper {
    int value; //기본형 primitive type -> read only

    public static void main(String[] args) {
        NumberWrapper n = new NumberWrapper(); //참조형 reference type -> writable
        n.value = 1;
        changeTo(n.value, 2);
        System.out.println("changed n.value = "+n.value);
        changeTo(n, 2); // 참조형 타입으로 넘기면 call stack 내에 있는 것이 아니고
        // heap에 있다
        // 그래서 함수 stack의 영향 받지 않음
        System.out.println("changed n = "+n.value);

    }

    static void changeTo(int value, int newValue){
        value = newValue; //여기서는 value가 2 였었다..
        // 인자를 위한 stack 이 함수가 끝나면서 사라져버림
        // 그래서 main에서 1이 찍힘
    }

    static void changeTo(NumberWrapper n, int newValue){
        n.value = newValue; // 여기서도 value가 2 이다

    }
}
