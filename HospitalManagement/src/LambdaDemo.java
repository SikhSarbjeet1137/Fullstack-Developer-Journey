
import java.util.*;

public class LambdaDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Java");
        names.add("Python");
        names.add("Angular");
        names.add("Django");
        names.add("TypeScript");

        // Normal for-each loop
        System.out.println("All Languages:");

        for (String name : names) {
            System.out.println(name);
        }

        // Lambda with forEach()
        System.out.println("\nUsing Lambda:");

        names.forEach(name -> {
            System.out.println(name);
        });

        // Languages containing 'a'
        System.out.println("\nLanguages containing 'a':");

        names.forEach(name -> {
            if (name.contains("a")) {
                System.out.println(name);
            }
        });
    }
}
