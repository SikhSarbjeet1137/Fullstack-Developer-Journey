class Student {

    String name;
    int age;

    Student() {
        this("Abhi", 21);
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class ThisKeywordDemo {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.display();
    }
}