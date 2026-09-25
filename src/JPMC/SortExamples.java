package JPMC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortExamples {

    class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " : " + salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<SortExamples.Employee>();
        employeeList.add(new SortExamples().new Employee("Alice", 70000));
        employeeList.add(new SortExamples().new Employee("Bob", 50000));
        employeeList.add(new SortExamples().new Employee("Charlie", 60000));

        System.out.println("Unsorted: " + employeeList);

        employeeList.sort(
                Comparator.comparing(Employee::getName)
        );
        System.out.println("Sorted by Name: " + employeeList);

        employeeList.sort(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
        );
        System.out.println("Sorted by Salary Desc: " + employeeList);

        employeeList.sort(
                Comparator.comparingDouble(Employee::getSalary)
        );
        System.out.println("Sorted by Salary Asc: " + employeeList);


        employeeList.sort(
                (e1, e2) ->
                        Double.compare(e2.getSalary(), e1.getSalary())
        );
        System.out.println("Sorted by Salary (Custom Asc): " + employeeList);

        employeeList.sort(
                (e1, e2) ->
                        Double.compare(e1.getSalary(), e2.getSalary())
        );
        System.out.println("Sorted by Salary (Custom Desc): " + employeeList);
    }
}
