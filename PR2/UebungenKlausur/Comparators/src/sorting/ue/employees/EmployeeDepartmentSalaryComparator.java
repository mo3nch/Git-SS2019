package sorting.ue.employees;

import java.util.Comparator;

public class EmployeeDepartmentSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee, Employee t1) {
        // Within the same department, sort by salary
        if (employee.getDepartment().equals(t1.getDepartment()))
        {
            if (t1.getSalary() < employee.getSalary())
                return -1;
            else if (t1.getSalary() > employee.getSalary())
                return 1;
            return 0;
        }

        return (employee.getDepartment().compareTo(t1.getDepartment()));
    }
}
