package day8;

import java.util.*;

public class Lottos {

    public static void main(String[] args) {
        Lottos l = new Lottos();
//        l.set();
//        l.treeSet();
        l.range();
    }

    private void range() {
        TreeSet<Integer> nums = new TreeSet<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(50) + 1;
            nums.add(num);
        }
        System.out.println(nums);
        System.out.println(nums.tailSet(20));
        System.out.println(nums.headSet(30));
        System.out.println(nums.tailSet(20).headSet(30));
        System.out.println(nums.subSet(20, 30));
    }

    private void treeSet() {
        Set<Integer> lottoNums = new TreeSet<>();
        Random r = new Random();
        while (lottoNums.size() < 6) {
            int num = r.nextInt(45) + 1;
            lottoNums.add(num);
        }
        System.out.println(lottoNums);
    }

    private void set() {
        Set<Integer> lottoNums = new HashSet<>();
        Random r = new Random();
        while (lottoNums.size() < 6) {
            int num = r.nextInt(45) + 1;
            lottoNums.add(num);
        }
        // 정렬
        List<Integer> nums = new ArrayList<>(lottoNums);
        Collections.sort(nums);
        System.out.println(nums);
    }


}
