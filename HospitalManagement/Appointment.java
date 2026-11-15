class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;

    public Appointment(int id, Patient patient, Doctor doctor,
                       String date, String status) {
        if (id <= 0) {
    throw new IllegalArgumentException("Invalid appointment ID");
}
if (!status.equals("Scheduled") &&
    !status.equals("Completed") &&
    !status.equals("Cancelled")) {

    throw new IllegalArgumentException("Invalid appointment status");
}
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }
void displayAppointment() {
    System.out.println("Appointment ID: " + id);
    System.out.println("Patient Name: " + patient.getName());
    System.out.println("Doctor Name: " + doctor.getName());
    System.out.println("Appointment Date: " + date);
    System.out.println("Status: " + status);
}
void updateStatus(String newStatus) {
    if(!"Scheduled".equals(newStatus)&&
    !"Complete".equals(newStatus)&&
    !"Cancelled".equals(newStatus)
    ){
        throw new IllegalArgumentException("Invalid appointment status");
    }
    this.status = newStatus;

}
}