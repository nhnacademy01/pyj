package day6;

public class ToString {
    public static void main(String[] args) {
        Person2 p1 = new Person2("hong", 180);
        System.out.println(p1.toString());
    }
}
class Person2 {
    String name;
    int height;
    public Person2(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // 이 toString이 없으면 object.Person2@75b84c92 이런식으로 출력이되고
    // toString 을 재정의하면 Person2{name='hong', height=180} 이쁘게 나온다
    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}