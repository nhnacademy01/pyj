import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMergeEx {
    public static void main(String[] args) {
        MapMergeEx mapMergeEx = new MapMergeEx();
        mapMergeEx.mapMerge();
    }

    private void mapMerge() {
        List<Employee> emps = List.of(
                new Employee(1, "Jordan", "Dooray!"),
                new Employee(2, "Dongmyo", "Dooray!"),
                new Employee(3, "Comtin", "Dooray!"),
                new Employee(4, "Manty", "Dooray!"),
                new Employee(5, "Coco", "NHN Edu"),
                new Employee(6, "Kizoo", "NHN Academy"),
                new Employee(7, "Marco", "NHN Academy"));
        // key: departmentName, value: employee count
        Map<String, Integer> empCountByDeptMap = new HashMap<>();
        for (Employee emp : emps) {
            Integer empCount = empCountByDeptMap.get(emp.deptName);
            if (empCount == null) {
                empCountByDeptMap.put(emp.deptName, 1);
            } else {
                empCountByDeptMap.put(emp.deptName, empCount + 1);
            }
        }
        System.out.println(empCountByDeptMap);

        // MERGE 이용시
//        empCountByDeptMap.merge(emp.deptName, 1, (oldValue, newValue) -> oldValue + newValue);
//    }
//    System.out.println(empCountByDeptMap);

    }

    class Employee {
        private int empNo;
        private String name;
        private String deptName;


        public Employee(int empNo, String name, String deptName) {
            this.empNo = empNo;
            this.name = name;
            this.deptName = deptName;
        }

        public int getEmpNo() {
            return empNo;
        }

        public String getName() {
            return name;
        }

        public String getDeptName() {
            return deptName;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empNo=" + empNo +
                    ", name='" + name + '\'' +
                    ", deptName='" + deptName + '\'' +
                    '}';
        }
    }
}
