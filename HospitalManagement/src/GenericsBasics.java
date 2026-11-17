import java.util.*;

public class GenericsBasics{
    public static void main(String[] args){
        ArrayList<Integer>numbers =new ArrayList<>();
        numbers.add(1000);
        numbers.add(5156);
        numbers.add(8985);
        numbers.add("Java");

        for(Integer number:numbers ){
        System.out.println("The Array List : "+numbers);
        }
    }
}