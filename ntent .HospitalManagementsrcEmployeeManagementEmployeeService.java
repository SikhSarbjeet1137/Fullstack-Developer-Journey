[1mdiff --git a/HospitalManagement/src/EmployeeManagement/EmployeeService.java b/HospitalManagement/src/EmployeeManagement/EmployeeService.java[m
[1mindex 1bf9727..2d132a1 100644[m
[1m--- a/HospitalManagement/src/EmployeeManagement/EmployeeService.java[m
[1m+++ b/HospitalManagement/src/EmployeeManagement/EmployeeService.java[m
[36m@@ -50,4 +50,16 @@[m [mpublic class EmployeeService {[m
 [m
     System.out.println("Employee Not Found!");[m
 }[m
[32m+[m[32mpublic void removeEmployee(int id) {[m
[32m+[m
[32m+[m[32m    boolean removed = employees.removeIf([m
[32m+[m[32m        employee -> employee.getId() == id[m
[32m+[m[32m    );[m
[32m+[m
[32m+[m[32m    if (removed) {[m
[32m+[m[32m        System.out.println("Employee Removed Successfully!");[m
[32m+[m[32m    } else {[m
[32m+[m[32m        System.out.println("Employee Not Found!");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/HospitalManagement/src/EmployeeManagement/Main.java b/HospitalManagement/src/EmployeeManagement/Main.java[m
[1mindex 74f717f..9f9dc20 100644[m
[1m--- a/HospitalManagement/src/EmployeeManagement/Main.java[m
[1m+++ b/HospitalManagement/src/EmployeeManagement/Main.java[m
[36m@@ -32,6 +32,13 @@[m [mservice.addEmployee(dev2);[m
             // Search Employee[m
             System.out.println("\n--- Search Employee ---");[m
             service.searchEmployee(101);[m
[32m+[m[32m            System.out.println("\n--- Remove Employee ---");[m
[32m+[m
[32m+[m[32mservice.removeEmployee(101);[m
[32m+[m
[32m+[m[32mSystem.out.println("\n--- Updated Employee List ---");[m
[32m+[m
[32m+[m[32mservice.displayEmployees();[m
 [m
         } catch (InvalidSalaryException e) {[m
 [m
