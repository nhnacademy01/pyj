package day6;

public class Clone {
    public static void main(String[] args) {
        Vehicle original = new Vehicle(1500, 300);
        Vehicle replica = (Vehicle) original.clone();
        System.out.println("original: " + original);
        System.out.println("replica: " + replica);
        System.out.println("original.hasCode: " + original.hashCode());
        System.out.println("replica.hashCode: " + replica.hashCode());
    }
}
class Vehicle implements Cloneable {    // Cloneable 구현
    int weight; // 기본형이기 때문에 shallow copy를 이용해도 문제가 생기지 않았따
    int speed;
    public Vehicle(int weight, int speed) {
        this.weight = weight;
        this.speed = speed;
    }
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}