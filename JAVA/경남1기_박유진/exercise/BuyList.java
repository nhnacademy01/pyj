package exercise;

import java.util.ArrayList;

public class BuyList extends FoodStand {
    private final ArrayList<Item> items = new ArrayList<>();


    public void add(Item item) {
        items.add(item);
        foodStand.remove(item.getName(), item.getAmount());
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static class Item extends BuyList {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }

}
