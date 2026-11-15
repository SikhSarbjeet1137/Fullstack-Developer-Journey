import java.util.ArrayList;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

   public void addEmployee(Employee employee)
        throws InvalidSalaryException {

    if (employee.getSalary() <= 0) {
        throw new InvalidSalaryException(
            "Salary must be greater than zero!"
        );
    }

    for (Employee existing : employees) {
        if (existing.getId() == employee.getId()) {
            System.out.println("Employee ID already exists!");
            return;
        }
    }

    employees.add(employee);
    System.out.println("Employee added successfully!");
}

    // Display All Employees
    public void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("-----------------------");
            employee.displayDetails();
        }
    }
    public void searchEmployee(int id) {

    for (Employee employee : employees) {

        if (employee.getId() == id) {
            System.out.println("Employee Found!");
            employee.displayDetails();
            return;
        }
    }

    System.out.println("Employee Not Found!");
}
}