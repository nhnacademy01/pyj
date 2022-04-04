package oop.oop10;

interface Flyable {
    void fly();
}
abstract class Animal {
    abstract void cry();
}
class Horse extends Animal {
    @Override
    public void cry() {
        System.out.println("히히힝~");
    }
}
public class Pegasus extends Horse implements Flyable {
    @Override
    public void fly() {
        System.out.println("페가수스가 하늘을 날아갑니다.");
    }
    public static final void main(String[] args) {
        Pegasus horse = new Pegasus();
        horse.fly();
        horse.cry();
    }
}