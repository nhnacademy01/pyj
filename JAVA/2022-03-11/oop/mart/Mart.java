//package oop.mart;
//
//public class Mart {
//    abstract class Customer {
//    }
//
//    class Vip extends Customer {
//    }
//
//    class GeneralMember extends Customer {
//    }
//
//}
//
//class FoodStand {
//    Stack<Food> foods
//
//    public Food bring() {
//        if (foods.isEmpty()) {
//            throw new NoMoreFoodException("food is empty");
//        }
//        return foods.pop();
//    }
//}
//
//class Cart {
//    List<Food> willBuyingFoods = new ArrayList<>();
//
//    public void add(food) {
//        willBuyingFoods.add(food);
//    }
//}
//
//interface Discountable {
//    long discount(long listPrice);
//}
//
//// vip 쿠폰
//class VipCoupon implements Discountable {
//    // 5만원 이상 구매 시 30% 할인
//    public long discount(long listPrice) {
//        if (listPrice < 50_000) {
//            return listPrice;
//        }
//        return (long)listPrice * 0.7;
//    }
//}
//
//// 마트전단지 쿠폰
//class MartFlyerCoupon implements Discountable {
//    // 만원 이상 구매 시 1,000원 할인
//    public long discount(long listPrice) {
//        if (listPrice < 10_000) {
//            return listPrice;
//        }
//        return listPrice - 1_000;
//    }
//}
//
//interface Discountable {
//    long discount(long listPrice);
//}
//
//// vip 쿠폰
//class VipCoupon implements Discountable {
//    // 5만원 이상 구매 시 30% 할인
//    public long discount(long listPrice) {
//        if (listPrice < 50_000) {
//            return listPrice;
//        }
//        return (long)listPrice * 0.7;
//    }
//}
//
//// 마트전단지 쿠폰
//class MartFlyerCoupon implements Discountable {
//    // 만원 이상 구매 시 1,000원 할인
//    public long discount(long listPrice) {
//        if (listPrice < 10_000) {
//            return listPrice;
//        }
//        return listPrice - 1_000;
//    }
//}
//
//class ShoppingCustomer {
//    Customer customer;
//    Bucket bucket;
//}