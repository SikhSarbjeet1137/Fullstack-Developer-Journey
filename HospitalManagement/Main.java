
abstract class User {

    private String name;
    private String email;
    private int age;

    public String getName() {
    return name;
}
   public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }
    // Parent constructor
    public User(String name, String email, int age) {
        if (age <= 0) {
    throw new IllegalArgumentException("Age must be greater than zero.");
}
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Abstract method
    abstract void displayRole();

    // Normal method
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
    }
}

// Patient inherits User
class Patient extends User {
    
    public Patient(String name, String email, int age) {
        super(name, email, age);
    }

    @Override
    void displayRole() {
        System.out.println("Role: Patient");
    }
}

class Doctor extends User {

    private String specialization;

    public Doctor(String name, String email, int age, String specialization) {

        super(name, email, age);

        this.specialization = specialization;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Doctor");
    }

    void displaySpecialization() {
        System.out.println("Specialization: " + specialization);
    }
}


// Main class
public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" Hospital Management System");
        System.out.println("================================");

        Patient patient = new Patient(
            "Abhi",
            "abhi@gmail.com",
            21
        );

        System.out.println("\n--- Patient Information ---");

        patient.displayInfo();
        patient.displayRole();

        Doctor doctor = new Doctor(
    "Dr. Sarbjeet",
    "sarbjeet@gmail.com",
    35,
    "Cardiologist"
);

System.out.println("\n--- Doctor Information ---");

doctor.displayInfo();
doctor.displayRole();
doctor.displaySpecialization();

User user1 = new Patient("Abhi", "abhi@gmail.com", 21);
User user2 = new Doctor(
    "Dr. Sarbjeet",
    "sarbjeet@gmail.com",
    35,
    "Cardiologist"
);

user1.displayRole();
user2.displayRole();
try {
    Patient invalidPatient = new Patient(
        "Test",
        "test@gmail.com",
        -5
    );
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}
Appointment appointment = new Appointment(
    101,
    patient,
    doctor,
    "15-11-2026",
    "Scheduled"
);
System.out.println("\n--- Updating Appointment ---");

appointment.updateStatus("Completed");

appointment.displayAppointment();

System.out.println("\n--- Appointment Details ---");
patient.setAge(22);
patient.displayInfo();

Appointment test = new Appointment(
    -1, patient, doctor, "15-11-2026", "Scheduled"
);
appointment.updateStatus("Random");
    }
}
