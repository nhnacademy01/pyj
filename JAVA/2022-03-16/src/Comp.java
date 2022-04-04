import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comp {

    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();
        workers.add(new Employee(1, "Kim"));
        workers.add(new Employee(2, "Nah"));
        workers.add(new Employee(3, "Pak"));
        workers.add(new Employee(4, "Lee"));

        System.out.println("이름의 오름차순 정렬 -----");
        workers.sort(new EmployeeNameComparator());
        System.out.println(workers);

        System.out.println("이름의 내림차순 정렬 -----");
        workers.sort(new EmployeeNameReversedComparator());
        System.out.println(workers);

        workers.sort(Comparator.comparing(Employee::getName).reversed());

    }

    static class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class EmployeeNameReversedComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.getName().compareTo(o1.getName());
        }


    }

    static class Employee implements Comparable<Employee> {
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
        public int compareTo(Employee o) {
            return this.empNo - o.empNo;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empNo=" + empNo +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
