
package model;

public abstract class User {

    private String name;
    private String email;
    private int age;

    public User(String name, String email, int age) {

        if (age <= 0) {
            throw new IllegalArgumentException(
                "Age must be greater than zero."
            );
        }

        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {

        if (age <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        this.age = age;
    }

    public abstract void displayRole();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
    }
}
