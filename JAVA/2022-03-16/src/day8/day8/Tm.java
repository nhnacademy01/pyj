package day8;

import java.util.Comparator;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

public class Tm {
    public static void main(String[] args) {
        Tm tm = new Tm();
//        tm.basic();
        tm.name();
    }

    private void name() {
        TreeMap<Employee, Integer> countMap = new TreeMap<>(comparing(Employee::getName));
        countMap.put(new Employee(1, "Dongmyo"), 230);
        countMap.put(new Employee(23, "Comtin"), 31);
        countMap.put(new Employee(70, "Jordan"), 484);
        countMap.put(new Employee(4, "Coco"), 2);
        countMap.put(new Employee(2, "Manty"), 665);

        System.out.println(countMap);
    }

    private void basic() {
//        TreeMap<Integer, String> map = new TreeMap<>();
    TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put(1, "Dongmyo");
        map.put(23, "Comtin");
        map.put(70, "Jordan");
        map.put(4, "Coco");
        map.put(2, "Manty");

        System.out.println(map);
    }
}
