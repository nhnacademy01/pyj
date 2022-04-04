package day8;

import java.util.Stack;

public class StackBuger {
    public static void main(String[] args) {
        Stack<String> burger = new Stack<>();

        burger.push("Bun1");
        burger.push("Source");
        burger.push("Petty");
        burger.push("Cheese");
        burger.push("lettuce");

//        burger.push("Bun2");    // !

        System.out.println("size: " + burger.size());
        System.out.println("peek: " + burger.peek());
        System.out.println("size: " + burger.size());
        System.out.println("pop: " + burger.pop());
        System.out.println("size: " + burger.size());
        System.out.println("Which is Petty: " + burger.search("Petty"));
        System.out.println(burger.pop());
        System.out.println(burger.pop());
        System.out.println(burger.pop());
        System.out.println("burger.empty(): " + burger.empty());
        System.out.println(burger.pop());
        System.out.println("burger.empty(): " + burger.empty());
        // burger.pop();
    }
}
