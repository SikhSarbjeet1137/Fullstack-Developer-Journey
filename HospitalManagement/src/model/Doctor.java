package model;

public class Doctor extends User {

    private String specialization;

    public Doctor(String name, String email, int age, String specialization) {

        super(name, email, age);

        this.specialization = specialization;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Doctor");
    }

    public void displaySpecialization() {
        System.out.println("Specialization: " + specialization);
    }
}