public class Main {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        try {

            // Create Developer
            Developer dev = new Developer(
                101, "Abhi", 50000, "Java"
            );
Developer dev2 = new Developer(
    101, "Rahul", 45000, "Python"
);

service.addEmployee(dev2);
            // Create Manager
            Manager manager = new Manager(
                102, "Sarbjeet", 80000, 5
            );

            // Add Employees
            service.addEmployee(dev);
            service.addEmployee(manager);
            

            // Display Employees
            System.out.println("\n--- Employee List ---");
            service.displayEmployees();

            // Search Employee
            System.out.println("\n--- Search Employee ---");
            service.searchEmployee(101);

        } catch (InvalidSalaryException e) {

            System.out.println("Error: " + e.getMessage());

        }

    }
}