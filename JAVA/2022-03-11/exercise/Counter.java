package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class Counter extends NhnMart {
    private final ArrayList<Food> foods = new ArrayList<>();

    private Basket basket;
    private Customer customer;


    public Counter(Basket basket, Customer customer) {
        this.basket = basket;
        this.customer = customer;
    }

    public int calculateBasket(Basket basket) {
        int amount = 0;
        for (Food food : basket.getFoods()) {
            System.out.println(food);
            amount += food.getPrice();
        }
        return amount;
    }

    public int applyDiscount(int amount) {
        customer.useCoupon(0);
        return (int) (amount * 0.9);
    }

    public int applyDiscount(int checkDiscount, int amount) {
        if (checkDiscount == 1) {
            if (amount >= 1000) {
                customer.useCoupon(checkDiscount);
                return (amount - 1000);
            } else {
                return 0;
            }
        }
        return amount;
    }

    public void giveCoupon(){
        customer.addCoupon(customer.getCouponCoount(), "20% 할인" );
        customer.showCoupon();
    }
    public int checkDiscount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getRemainBalance(int amount) {
        if(customer.getMoney() < amount){
            System.out.println("잔액이 부족합니다.");
        }
        return (customer.getMoney() - amount);
    }

    public Basket getBasket() {
        return basket;
    }
}
