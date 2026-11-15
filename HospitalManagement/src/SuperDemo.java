class Employee{
    Employee(String name){
        System.out.println("Employee: "+name);
    }
}

class Developer extends Employee{
    Developer(String name){
        super(name);
        System.out.println("Developer Construtor");
    }
}

public class SuperDemo{
    public static void main(String[] args){
        Developer d=new Developer("Abhi");
    }
}