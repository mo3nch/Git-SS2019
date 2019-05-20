package sorting.ue.employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeDemo {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1337, "The Elite Man", 9001.00, "Important i guess"));
        employees.add(new Employee(1336, "Still not elite", 8000.00, "Important i guess"));
        employees.add(new Employee(51, "Schottermitzi", 1300.00, "Lohnverrechnung"));
        employees.add(new Employee(69, "Starlord", 10000.00, "Outer space"));

        Collections.sort(employees);
        System.out.println("Hereby I present you employees ordered by employee number:");
        System.out.println("employees = \n" + employees);

        Collections.sort(employees, new EmployeeDepartmentSalaryComparator());
        System.out.println("\nNow they are sorted by department and salary:");
        System.out.println("employees = \n" + employees);

        System.out.println("\nThe end is near, sorted by name, you get:");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return (employee.getName().compareTo(t1.getName()));
            }
        });
        System.out.println("employees = \n" + employees);
    }




}
