package oop.oop5;

public class Animal {

    void cry(){
        System.out.println("울 수 있어!");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();
        Cat cat = new Cat();
        cat.cry();
        Animal animal = new Animal();
        animal.cry();
    }
}

class Dog extends Animal{
    @Override
    void cry(){
        System.out.println("개가 우는중");
    }
}

class Cat extends Animal{
    @Override
    void cry(){
        System.out.println("고양이가 우는중");
    }
}
