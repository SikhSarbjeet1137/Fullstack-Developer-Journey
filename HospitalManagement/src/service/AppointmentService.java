
package service;
import java.util.HashMap;
import java.util.ArrayList;
import model.Appointment;

public class AppointmentService {


    private ArrayList<Appointment> appointments = new ArrayList<>();

private HashMap<Integer, Appointment> appointmentMap = new HashMap<>();


public void addAppointment(Appointment appointment) {

    if (appointmentMap.containsKey(appointment.getId())) {
        throw new IllegalArgumentException("Appointment ID already exists!");
    }

    appointments.add(appointment);
    appointmentMap.put(appointment.getId(), appointment);

    System.out.println("Appointment added successfully!");
}

public void addAppointmentToMap(Appointment appointment) {
    appointmentMap.put(appointment.getId(), appointment);
    System.out.println("Appointment saved in HashMap!");
}

public Appointment searchUsingMap(int id) {
    return appointmentMap.get(id);
}
public boolean appointmentExists(int id) {
    return appointmentMap.containsKey(id);
}

public void displayAllAppointments() {

    for (Appointment appointment : appointments) {
        appointment.displayAppointment();
        System.out.println("----------------------");
    }
}
public int getTotalAppointments() {
    return appointments.size();
}
public Appointment searchAppointmentById(int id) {

    for (Appointment appointment : appointments) {

        if (appointment.getId() == id) {
            return appointment;
        }
    }

    return null;
}
public boolean removeAppointment(int id) {

    Appointment appointment = appointmentMap.remove(id);

    if (appointment == null) {
        return false;
    }

    appointments.remove(appointment);
    return true;
}
public boolean updateAppointmentStatus(int id, String newStatus) {

    Appointment appointment = searchAppointmentById(id);

    if (appointment != null) {
        appointment.updateStatus(newStatus);
        return true;
    }

    return false;
}
}
