
import model.Patient;
import model.Doctor;
import model.Appointment;
import service.AppointmentService;

public class Main {

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("  HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("==============================");

        // Create Patient
        Patient patient = new Patient(
            "Abhi",
            "abhi@gmail.com",
            21
        );

        // Create Doctor
        Doctor doctor = new Doctor(
            "Dr. Sarbjeet",
            "sarbjeet@gmail.com",
            35,
            "Cardiologist"
        );

        // Display Patient Information
        System.out.println("\n--- Patient Information ---");
        patient.displayInfo();
        patient.displayRole();

        // Display Doctor Information
        System.out.println("\n--- Doctor Information ---");
        doctor.displayInfo();
        doctor.displayRole();
        doctor.displaySpecialization();

        // Create Appointment Service
        AppointmentService service = new AppointmentService();

        // Create Appointments
        Appointment appointment1 = new Appointment(
            101, patient, doctor, "15-11-2026", "Scheduled"
        );

        Appointment appointment2 = new Appointment(
            102, patient, doctor, "16-11-2026", "Scheduled"
        );

        // Add Appointments
        System.out.println("\n--- Adding Appointments ---");
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);

        // Display All Appointments
        System.out.println("\n--- All Appointments ---");
        service.displayAllAppointments();

        // Total Appointments
        System.out.println("Total Appointments: "
                + service.getTotalAppointments());

        // Search Appointment Using ArrayList/Service
        System.out.println("\n--- Search Appointment ---");

        Appointment result = service.searchAppointmentById(102);

        if (result != null) {
            result.displayAppointment();
        } else {
            System.out.println("Appointment not found!");
        }

        // Remove Appointment 101
        System.out.println("\n--- Remove Appointment ---");

        boolean removed = service.removeAppointment(101);

        if (removed) {
            System.out.println("Appointment removed successfully!");
        } else {
            System.out.println("Appointment not found!");
        }

        System.out.println("Total Appointments: "
                + service.getTotalAppointments());

        // Update Appointment 102 Status
        System.out.println("\n--- Update Appointment ---");

        boolean updated = service.updateAppointmentStatus(
            102, "Completed"
        );

        if (updated) {
            System.out.println("Appointment updated successfully!");
        } else {
            System.out.println("Appointment not found!");
        }

        // Display Updated Appointment
        service.displayAllAppointments();

        // HashMap Testing
        System.out.println("\n--- HashMap Testing ---");

        // Check Appointment Exists
        System.out.println("Appointment 102 exists: "
                + service.appointmentExists(102));

        // Search Using HashMap
        Appointment found = service.searchUsingMap(102);

        if (found != null) {
            System.out.println("\nAppointment Found Using HashMap:");
            found.displayAppointment();
        } else {
            System.out.println("Appointment not found!");
        }

        // Remove Appointment 102
        System.out.println("\n--- HashMap Removal Test ---");

        boolean mapRemoved = service.removeAppointment(102);

        System.out.println("Removed: " + mapRemoved);

        // Verify Removal
        System.out.println("Appointment 102 exists: "
                + service.appointmentExists(102));

        System.out.println("Total Appointments: "
                + service.getTotalAppointments());

        System.out.println("\n==============================");
        System.out.println("       PROGRAM COMPLETED");
        System.out.println("==============================");
    }
}
