import java.util.*;

public class IteratorVsListIterator {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Abhi");
        names.add("Rahul");
        names.add("Raj");

        ListIterator<String> iterator = names.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Backward:");

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}