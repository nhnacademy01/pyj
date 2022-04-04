package oop.oop6;//package oop.oop6;
//
//public class Super {
//    public static void main(String[] args) {
//        Car car = new Car();
//        car.speed = 10;
//        System.out.println("speed = "+car.getSpeed());
//        // car에는 getSpeed가 없다
//        // 그래서 car의 부모인 Vehicle 의 getSpeed 를 사용하는 것
//        // 근데 vehicle 에는 speed를 초기화시켜주지 않았기 때문에
//        //   default 값인 0이 들어가있다
//        System.out.println("vehicleSpeed = "+car.getVehicleSpeed());
//        // car.speed 가 나온다
//    }
//}
//
//class Vehicle{
//    int speed;
//
//    int getSpeed(){
//        return speed;
//    }
//}
//
//class Car extends Vehicle{
//    int speed;
//
//    int getVehicleSpeed(){
//        return this.speed;
//    }
//}

class Super{
    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 10;
        System.out.println("speed = "+car.getSpeed());
        car.setSpeed(20);
        System.out.println("speed = "+car.getSpeed());

    }
}

class Vehicle{
    int speed;
    int getSpeed(){
        return speed;
    }
}

class Car extends Vehicle{
    int speed;

    // 방법 1
    // -> vehicle이랑 똑같은 클래스가 되어서 .. 추천하지는 않음
    @Override
    int getSpeed(){
        return this.speed;
    }

    // 방법 2
    int setSpeed(int speed){
        this.speed = speed;
        return speed;
    }
}