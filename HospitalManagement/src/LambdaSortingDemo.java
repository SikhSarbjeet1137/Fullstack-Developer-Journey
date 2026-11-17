
import java.util.*;

public class LambdaSortingDemo {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);

        // Ascending order
        numbers.sort((a, b) -> Integer.compare(a, b));

        System.out.println("Ascending: " + numbers);

        // Descending order
        numbers.sort((a, b) -> Integer.compare(b, a));

        System.out.println("Descending: " + numbers);
    }
}
