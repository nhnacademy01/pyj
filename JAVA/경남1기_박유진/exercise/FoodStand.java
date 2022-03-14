package exercise;

import java.util.ArrayList;

public class FoodStand extends NhnMart {
    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }

    public void remove(String name, int amount) {
        int count = 0;
        for (Food food : foodStand.foods) {
            if (name.equals(food.getName()) && count < amount) {
                food.setState(0);
                count += 1;
            }
        }


        // TODO
//        for(Food food: foods){
//            if(food.getName().equals(name)){
//                food.setStock(food.getStock() - amount);
//            }
//        }
    }

    public ArrayList<Food> getFoodsFromFoodStand(BuyList buyList) {
        final ArrayList<Food> possibleBuyItems = new ArrayList<>();

        for (BuyList.Item item : buyList.getItems()) {
            for (Food food : foods) {
                if (item.getName().equals(food.getName())) {
                    possibleBuyItems.add(new Food(item.getName(), item.getAmount() * food.getPrice()));
                    break;
                }
            }
        }
        return possibleBuyItems;
    }

    public int prohibitBuyFood(String wantedFood, int wantedFoodCount) {
        boolean flag = false;
        for (Food food : foods) {
            if (food.getState() == 0 || !food.getName().equals(wantedFood)) {
                flag = true;
            }else{
                flag = false;
            }
        }

        if(flag){
            System.out.println("존재하지 않는 상품입니다.");
            return 0;
        }
        return 1;
    }
}
