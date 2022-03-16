package day8;

import java.util.LinkedList;
import java.util.Queue;

public class Qe {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.add("NHN");
        q.offer("ACADEMY");
        System.out.println("q: " + q);
        System.out.println("q.element(): " + q.element());
        System.out.println("q.peek(): " + q.peek());
        System.out.println("q.remove(): " + q.remove());
        System.out.println("q.size(): " + q.size());
        System.out.println("q.poll(): " + q.poll());
        System.out.println("q.empty? " + q.isEmpty());
        System.out.println("q.peek(): " + q.poll());
        System.out.println("q.poll(): " + q.poll());
//         q.remove(); // 주석을 제거하면?
//         q.element(); // 주석을 제거하면? (2)
    }
}
