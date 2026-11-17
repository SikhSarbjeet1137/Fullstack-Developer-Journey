
import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
            10, 20, 30, 40, 50, 60
        );

        List<Integer> result = numbers.stream()

            .filter(n -> n >= 30)

            .map(n -> n * 3)

            .collect(Collectors.toList());

        System.out.println("Original: " + numbers);

        System.out.println("Result: " + result);
    }
}
