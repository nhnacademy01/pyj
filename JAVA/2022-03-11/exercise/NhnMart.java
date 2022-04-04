package exercise;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static exercise.NhnMart.foodStand;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart(); // 식품 매대에 식품 채우기

        BuyList buyList = inputBuyListFromShell();

        Customer jordan = new Customer(buyList);

        jordan.bring(mart.provideBasket());

        // 식품을 담는다
        Basket basket = jordan.pickFoods(mart.getFoodStand(jordan.getBuyList()));

        // 카운터에서 계산한다
        jordan.payTox(mart.getCounter(basket, jordan));
    }


    private static BuyList inputBuyListFromShell() {
        //Scanner에서 buyList 만들기
        Scanner scanner = new Scanner(System.in);
        BuyList buyList = new BuyList();

        System.out.println("NHN 마트에 오신 것을 환영합니다.");
        int checkKeepBuying = 1;

        while (checkKeepBuying == 1) {
            NhnMart.showFoodStand();

            System.out.println("사고 싶은 물건을 골라주세요.");
            String wantedFood = scanner.next();

            System.out.println(wantedFood + "를 몇 개 구매하실건가요?");
            int wantedFoodCount = scanner.nextInt();
            checkKeepBuying = foodStand.prohibitBuyFood(wantedFood, wantedFoodCount);

            buyList.add(new BuyList.Item(wantedFood, wantedFoodCount));

            System.out.println("더 구매하실 물건이 있으시면 1번을 눌러주세요.");
            checkKeepBuying = scanner.nextInt();
        }
        System.out.println("구매를 종료합니다.");
        return buyList;
    }
}

public class NhnMart {
    static final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란(30개)", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    static void showFoodStand() {
        String pastFoodName = "";
        int count = 0;

        for (Food food : foodStand.getFoods()) {
            String newFoodName = food.getName();
            if (pastFoodName != newFoodName){
                count = 1;
            }else{
                count += 1;
            }
            if(food.getState()==1) {
                System.out.println(count+"번째 "+ food.toString());
                pastFoodName = food.getName();
            }
        }
        System.out.println();
    }

    public Basket provideBasket() {
        return new Basket();
    }


    public ArrayList<Food> getFoodStand(BuyList buyList) {
        return foodStand.getFoodsFromFoodStand(buyList);
    }

    public Counter getCounter(Basket basket, Customer customer) {
        return new Counter(basket, customer);
    }
}
