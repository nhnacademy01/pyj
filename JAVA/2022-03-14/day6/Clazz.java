package day6;

public class Clazz {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = DcMoney.class;   // 리터럴
        Class clazz2 = new DcMoney(10_000, "WON").getClass();
        Class clazz3 = Class.forName("day6.DcMoney");

        System.out.println("clazz1: "+clazz1.toString());
        System.out.println("clazz2: "+clazz2.toString());
        System.out.println("clazz3: "+clazz3.toString());
    }
}
