class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class GenericBox {

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();

        stringBox.setValue("Java Programming");

        System.out.println(stringBox.getValue());

        Box<Double> doubleBox =new Box<>();
        doubleBox.setValue(854.45);
        System.out.println(doubleBox.getValue());


        Box<Integer> integerBox = new Box<>();

        integerBox.setValue(100);

        System.out.println(integerBox.getValue());
    }
}