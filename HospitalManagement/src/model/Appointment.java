
package model;

public class Appointment {

    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;

    // Constructor
    public Appointment(int id, Patient patient, Doctor doctor,
                       String date, String status) {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        if (!"Scheduled".equals(status) &&
            !"Completed".equals(status) &&
            !"Cancelled".equals(status)) {

            throw new IllegalArgumentException("Invalid appointment status");
        }

        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }

    // Getter
    public int getId() {
        return id;
    }

    // Display appointment
    public void displayAppointment() {
        System.out.println("Appointment ID: " + id);
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Appointment Date: " + date);
        System.out.println("Status: " + status);
    }

    // Update appointment status
    public void updateStatus(String newStatus) {

        if (!"Scheduled".equals(newStatus) &&
            !"Completed".equals(newStatus) &&
            !"Cancelled".equals(newStatus)) {

            throw new IllegalArgumentException("Invalid appointment status");
        }

        this.status = newStatus;
    }
}
