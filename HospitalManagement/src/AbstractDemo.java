abstract class Employee{
    String name;

    Employee(String name){
        this.name=name;
    }
    abstract void calculatorSalary();

    void displayName(){
        System.out.println("Employee: "+name);
    }
}

class Developer extends Employee{
    Developer(String name){
        super(name);
    }
    @Override
    void calculatorSalary(){
        System.out.println("Developer Salary 50000");
    }
}

class Manager extends Employee{
    Manager(String name){
        super(name);
    }
    @Override
    void calculatorSalary(){
        System.out.println("Manager Salary 80000");
    }
}

public class AbstractDemo{
    public static void main(String[] args){
        Developer dev=new Developer("Abhi");
        dev.displayName();
        dev.calculatorSalary();

        Manager mange=new Manager("Sarbjeet");
        mange.displayName();
        mange.calculatorSalary();
    }
}