package model;

public class Patient extends User {

    public Patient(String name, String email, int age) {
        super(name, email, age);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Patient");
    }
}