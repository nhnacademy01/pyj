import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapEx {
    static List<Employee> workers = List.of(
            new Employee(1, "Jordan"),
            new Employee(2, "Coco"),
            new Employee(3, "Comtin"),
            new Employee(4, "Yoda"));
    static Map<Integer, Employee> workerMap = new HashMap<>();

    static {
        for (Employee worker : workers) {
            workerMap.put(worker.getEmpNo(), worker);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = findWorkerByEmpNo(1);
        Employee emp2 = findWorkerByEmpNo(2);
        Employee emp3 = findWorkerByEmpNo(3);
        Employee emp4 = findWorkerByEmpNo(4);
        System.out.println(emp4);
    }

    private static Employee findWorkerByEmpNo(Integer empNo) {
//        for (Employee worker : workers) {
//            if (worker.getEmpNo().equals(empNo)) {
//                return worker;
//            }
//        }
//        return null;
        // 순회 비용을 줄여보자 !

//        Map<Integer, Employee> map = new HashMap<>();
//        for (Employee worker : workers) {
//            map.put(worker.getEmpNo(), worker);
//        }
//        return map.get(empNo);

        // map을 만드느라 순회함 + map 만드느라 메모리 사용

        return workerMap.get(empNo);
        // 순회비용 왕많이 줄어듦
    }

    static class Employee implements Comparable<Comp.Employee> {
        private Integer empNo;
        private String name;
        // SKIP getter, toString


        public Employee(Integer empNo, String name) {
            this.empNo = empNo;
            this.name = name;
        }


        public Integer getEmpNo() {
            return empNo;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empNo=" + empNo +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Comp.Employee o) {
            return 0;
        }
    }
}
