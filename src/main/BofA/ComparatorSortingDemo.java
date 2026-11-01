package BofA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
COMMENT Collections.sort(EmployeeTests,(e1, e2) -> e1.getName().compareTo(e2.getName()));

COMMENT Collections.sort(EmployeeTests,Comparator.comparing(Employee::getName))
COMMENT Collections.sort(EmployeeTests,Comparator.comparingInt(Employee::getId))
COMMENT Collections.sort(EmployeeTests,Comparator.comparingDouble(Employee::getSalary))
COMMENT Collections.sort(EmployeeTests,Comparator.reverseOrder())
COMMENT Collections.sort(EmployeeTests,Comparator.naturalOrder()
COMMENT Collections.sort(EmployeeTests,comparator.reversed()
COMMENT Collections.sort(EmployeeTests,comparator.thenComparing(...)
COMMENT Collections.sort(EmployeeTests,Comparator.nullsFirst(...)
COMMENT Collections.sort(EmployeeTests,Comparator.nullsLast(...))
 */
public class ComparatorSortingDemo {

    public static void main(String[] args) {

        List<EmployeeTest> EmployeeTests = new ArrayList<>();

        EmployeeTests.add(new EmployeeTest(103, "John", "IT", 90000));
        EmployeeTests.add(new EmployeeTest(101, "Alice", "HR", 75000));
        EmployeeTests.add(new EmployeeTest(105, "Bob", "IT", 85000));
        EmployeeTests.add(new EmployeeTest(102, "David", "Finance", 95000));
        EmployeeTests.add(new EmployeeTest(104, "Charlie", "HR", 75000));

        System.out.println("Original List");
        printEmployeeTests(EmployeeTests);

        // 1. Sort by ID Ascending
        Collections.sort(EmployeeTests,
                Comparator.comparingInt(EmployeeTest::getId));

        System.out.println("\nSort By ID Ascending");
        printEmployeeTests(EmployeeTests);

        // 2. Sort by ID Descending
        Collections.sort(EmployeeTests,
                Comparator.comparingInt(EmployeeTest::getId).reversed());

        System.out.println("\nSort By ID Descending");
        printEmployeeTests(EmployeeTests);

        // 3. Sort by Name Ascending
        Collections.sort(EmployeeTests,
                Comparator.comparing(EmployeeTest::getName));

        System.out.println("\nSort By Name");
        printEmployeeTests(EmployeeTests);

        // 4. Sort by Salary Ascending
        Collections.sort(EmployeeTests,
                Comparator.comparingDouble(EmployeeTest::getSalary));

        System.out.println("\nSort By Salary Ascending");
        printEmployeeTests(EmployeeTests);

        // 5. Sort by Salary Descending
        Collections.sort(EmployeeTests,
                Comparator.comparingDouble(EmployeeTest::getSalary)
                        .reversed());

        System.out.println("\nSort By Salary Descending");
        printEmployeeTests(EmployeeTests);

        // 6. Sort by Department
        Collections.sort(EmployeeTests,
                Comparator.comparing(EmployeeTest::getDepartment));

        System.out.println("\nSort By Department");
        printEmployeeTests(EmployeeTests);

        // 7. Multiple Field Sorting
        // Department -> Salary Desc -> Name
        Collections.sort(EmployeeTests,
                Comparator.comparing(EmployeeTest::getDepartment)
                        .thenComparing(Comparator.comparingDouble(EmployeeTest::getSalary)
                                .reversed())
                        .thenComparing(EmployeeTest::getName));

        System.out.println("\nSort By Department, Salary Desc, Name");
        printEmployeeTests(EmployeeTests);

        // 8. Lambda Comparator
        Collections.sort(EmployeeTests,
                (e1, e2) -> e1.getName().compareTo(e2.getName()));

        System.out.println("\nLambda Comparator - Name");
        printEmployeeTests(EmployeeTests);

        // 9. Anonymous Comparator Class
        Collections.sort(EmployeeTests, new Comparator<EmployeeTest>() {
            @Override
            public int compare(EmployeeTest e1, EmployeeTest e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });

        System.out.println("\nAnonymous Comparator - Salary");
        printEmployeeTests(EmployeeTests);
    }

    private static void printEmployeeTests(List<EmployeeTest> EmployeeTests) {
        EmployeeTests.forEach(System.out::println);
    }
}


class EmployeeTest {

    private int id;
    private String name;
    private String department;
    private double salary;

    public EmployeeTest(int id, String name,
                        String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "EmployeeTest{id=%d, name='%s', dept='%s', salary=%.2f}",
                id, name, department, salary);
    }
}