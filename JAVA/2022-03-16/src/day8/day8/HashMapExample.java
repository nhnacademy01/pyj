package day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {
    static List<Employee> workers = List.of(
            new Employee(1, "Jordan"),
            new Employee(2, "Coco"),
            new Employee(3, "Comtin"),
            new Employee(4, "Yoda"));
    static Map<Integer, Employee> workerMap = new HashMap<>();
    static {
        for (Employee worker : workers) {   // n
            workerMap.put(worker.getEmpNo(), worker);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = findWorkerByEmpNo(1); // 1
        Employee emp2 = findWorkerByEmpNo(2); // 1
        Employee emp3 = findWorkerByEmpNo(3); // 1
        Employee emp4 = findWorkerByEmpNo(4); // 1
        System.out.println(emp4);
    }

    private static Employee findWorkerByEmpNo(Integer empNo) {
        // empNo:Employee
        return workerMap.get(empNo);
    }
}