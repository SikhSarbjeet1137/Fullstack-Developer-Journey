class Patient{
    String name;

    Patient(String name){
        this.name=name;
    }
}

class Doctor{

    void treatPatient(Patient patient){
        System.out.println("Doctor is treating : " + patient.name);
    }

}

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Abhi");
        Doctor doctor = new Doctor();
        doctor.treatPatient(patient);
    }
}