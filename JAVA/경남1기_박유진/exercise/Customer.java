package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends NhnMart {
    private final int money;
    private String[] coupon;
    private final BuyList buyList;
    private Basket basket;

    public Customer(BuyList buyList) {
        this.money = 20_000;
        this.coupon = new String[]{"10% 할인", "1000원 할인", ""};
        this.buyList = buyList;
    }

    public void bring(Basket basket) {
        this.basket = basket;
    }

    public Basket pickFoods(ArrayList<Food> possibleBuyItems) {
        for (Food food : possibleBuyItems) {
            basket.add(food);
        }
        return basket;
    }

    public void payTox(Counter counter) {
        System.out.println();
        int amount = counter.calculateBasket(counter.getBasket());
        System.out.printf("총 가격은 %,d원 입니다. %n", amount);

        amount = counter.applyDiscount(amount);
        System.out.printf("10%% 할인 후 %d원 입니다.%n", amount);

        System.out.println("1000원 할인을 추가적용할까요? (1.네 2.아니요)");
        int checkDiscount = counter.checkDiscount();
        amount = counter.applyDiscount(checkDiscount, amount);
        System.out.printf("할인 후 %,d원 입니다.%n", amount);

        amount = counter.getRemainBalance(amount);
        System.out.printf("고객님 결제 후 잔액: %,d %n", amount);

        System.out.println("방문해주셔서 감사합니다");
        System.out.println("쿠폰을 추가로 드립니다.");
        counter.giveCoupon();
    }

    public BuyList getBuyList() {
        return buyList;
    }

    public int getMoney() {
        return money;
    }

    public void showCoupon() {
        System.out.print("가지고 있는 쿠폰 : ");
        for (int i = 0; i < coupon.length; i++) {
            if (coupon[i] != "") {
                System.out.print(coupon[i] + " ");
            }
        }
        System.out.println();
    }

    public void useCoupon(int index) {
        coupon[index] = "";
    }

    public void addCoupon(int index, String content) {
        coupon[index] = content;
    }

    public int getCouponCoount(){
        return coupon.length-1;
    }


}
