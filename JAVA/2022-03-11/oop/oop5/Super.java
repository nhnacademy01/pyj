package oop.oop5;

public class Super {
    public static void main(String[] args) {
        SuperCar scar = new SuperCar();
    }
}

class Vehicle{
    public Vehicle(){
        super();
        System.out.println("Vehicle 생성");
    }
}

class Car extends Vehicle{
    public Car(){
         super();
        System.out.println("Car 생성");
    }
}

class SuperCar extends Car{
    public SuperCar(){
         super();
        System.out.println("SuperCar 생성");
    }
}
