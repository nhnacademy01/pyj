package exercise;

public class Food {
    private final String name;
    private final int price;
    private int state; // 0은 판매불가 1은 판매가능


    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        this.state = 1;
    }

    public String getName() {

        return name;
    }

    public int getPrice() {

        return price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {

        return name + " " + price + "원";
    }

}
