package day8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Comp {
    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();
        workers.add(new Employee(1, "Kim"));
        workers.add(new Employee(2, "Nah"));
        workers.add(new Employee(3, "Pak"));
        workers.add(new Employee(4, "Lee"));

        System.out.println(workers);
//         workers.sort(new EmployeeNameReversedComparator());
        workers.sort(comparing(Employee::getName).reversed());
        System.out.println(workers);
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class EmployeeNameReversedComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        // return  o1.getName().compareTo(o2.getName()) * -1;
        return o2.getName().compareTo(o1.getName());
    }
}

class Employee implements Comparable<Employee> {
    private Integer empNo;
    private String name;

    public Employee(Integer empNo, String name) {
        this.empNo = empNo;
        this.name = name;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Employee o) {
        return this.empNo - o.empNo;
    }
}