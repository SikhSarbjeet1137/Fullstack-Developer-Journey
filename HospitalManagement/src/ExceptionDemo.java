import java.io.FileReader;
import java.io.IOException;


public class ExceptionDemo{
    static void validateSalary(double salary)
            throws InvalidSalaryException {

        if (salary < 0) {
            throw new InvalidSalaryException(
                "Salary cannot be negative!"
            );
        }

        System.out.println("Valid Salary: " + salary);
    }


    public static void main(String[] args){
   try {
            validateSalary(-5000);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program Continue");
    }
}