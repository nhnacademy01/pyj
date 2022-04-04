package oop.oop8;

public class ProtectedModifier {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColorAndSpeed("red", 20);
        System.out.println("color: " + car.getColor());
        System.out.println("speed: " + car.getSpeed());

        car.color = "blue"; // 이건 왜 될까?
        // car가 Vehicle의 자식이여서 protected는 자식이 접근할 수 있어서 그런것이 아니다
        // car에서 접근하는 것이 아니라 !!
        // ProtectedModifier에서 접근하는 것이다
        // 같은 패키지 내여서 protected를 붙여도 된 것이다

        // 결론 car가 vehicle을 상속받아서 된 것이 아니라 같은 패키지 내여서 그런 것이다
        System.out.println("color: " + car.getColor());
        car.setSpeed(100);
        System.out.println("speed: " + car.getSpeed());
    }
}
class Vehicle {
    private int speed;  // 자식 접근 불가
    String color; // 자식 접근 가능

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getColor() {
        return color;
    }
}
class Car extends Vehicle {
    public void setColorAndSpeed(String color, int speed) {
        this.color = color; // super.color = color;
        super.setSpeed(speed);
    }
}