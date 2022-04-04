import java.util.Iterator;
import java.util.Stack;

public class CageEx {
    public static void main(String[] args) {

        CageEx cageEx = new CageEx();
        cageEx.cageListEx();

    }

    abstract class Animal {
        public abstract void cry();
    }

    class Dog extends Animal {
        @Override
        public void cry() {
            System.out.println("Woof!");
        }
    }

    class Cat extends Animal {
        @Override
        public void cry() {
            System.out.println("Nyan~");
        }
    }

    class Cage<T extends Animal> implements Iterable {  // Bounded Type Parameter
        private Stack<T> animals = new Stack<>();

        public void add(T animal) {
            animals.push(animal);
        }

        public T get() {
            return animals.pop();
        }

        @Override
        public Iterator iterator() {
            return null;
        }
    }

    void cageListEx() {
        Cage<Dog> dogCage = new Cage<>();
        dogCage.add(new Dog());
        System.out.println(dogCage.get());

        Cage<Cat> catCage = new Cage<>();
        catCage.add(new Cat());
        System.out.println(catCage.get());
        // catCage.add(new Dog());  // 컴파일 오류
        // Cage<String> stringCage = new Cage<>(); // 컴파일 오류

        Cage<Animal> animalCage = new Cage<>();
        animalCage.add(new Dog());  // Dog도 가능하고,
        animalCage.add(new Cat());  // Cat도 가능
        System.out.println("animalCage 출력: " + animalCage.get());
        System.out.println(animalCage.get());

//        for(Animal animal : animalCage){
//            System.out.println("animalCage 돌아가유 : "+animal);
//        }

        // 오류가 나는 이유는
        // animalCage는 iterable 인터페이스를 구현하지 않아서 for each를 하지 못한다
        // for each를 돌리려면 animalCage 에서 iterable 인터페이스를 구현해야한다

        // animals(stack) -> vector -> list -> collections 확장
        // class cage <> implements interable 을 해서 구현하면 된다
    }

}
