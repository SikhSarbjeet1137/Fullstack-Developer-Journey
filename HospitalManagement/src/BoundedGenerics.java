
class Calculator<T extends Number> {

    private T number;

    Calculator(T number) {
        this.number = number;
    }

    public double square() {
        return number.doubleValue() * number.doubleValue();
    }
}

public class BoundedGenerics {

    public static void main(String[] args) {

        Calculator<Integer> intCalc = new Calculator<>(10);
        System.out.println("Integer Square: " + intCalc.square());

        Calculator<Double> doubleCalc = new Calculator<>(5.5);
        System.out.println("Double Square: " + doubleCalc.square());

        // Calculator<String> strCalc = new Calculator<>("Java");
        // This will produce a compilation error.
    }
}
