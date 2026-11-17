import java.util.*;

public class RemoveIfDemo{
    public static void main(String[] args){
        List<Integer> number=new ArrayList<>(); 
        number.add(35);
        number.add(65);
        number.add(335);
        number.add(30);
        number.add(2);
        number.add(5);
        number.add(25);
        number.add(635);
        number.add(335);
        number.add(3);
        number.add(6);
        number.add(9);

        System.out.println("Before : "+number);

        number.removeIf(numbers->numbers>50);

        System.out.println("After : "+number);


    }
}