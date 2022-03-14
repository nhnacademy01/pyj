package oop.oop7;

public class Super {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        car.speedUp();
        System.out.println("car speed: " + car.getSpeed());

        SuperCar scar = new SuperCar();
        scar.drive();
        scar.speedUp();
        System.out.println("scar speed: " + scar.getSpeed());
//        scar.boosterOn();
        System.out.println("scar speed: " + scar.getSpeed());
    }
}

class Vehicle {
    private int speed;

    void drive() {
        System.out.println("Drive Vehicle");
    }

    void speedUp() {
        speed++;
    }

    int getSpeed() {
        return this.speed;
    }

    int setSpeed(int speed) {
        this.speed = speed;
        return speed;
    }
}

class Car extends Vehicle {
    @Override
    void speedUp() {
//        int speed  = setSpeed(getSpeed()*2);
        super.speedUp(); // vehicle.speedUp()
        super.speedUp(); // vehicle.speedUp()
    }
}

class SuperCar extends Car {
    public static final int MAX_SPEED = 300;

    @Override
    void speedUp() {
//        int speed  = setSpeed(getSpeed()*4);
        super.speedUp(); // Car.speedUp()
        super.speedUp(); // Car.speedUp()
    }
//    void boosterOn() {
//        speed = MAX_SPEED;
//    }
}