import java.util.*;

public class ArrayListVsLinkedList{
    public static void main(String[] args){
        List<String> arraylist=new ArrayList<>();
        arraylist.add("Java");
        arraylist.add("Python");
        arraylist.add("React");

        System.out.println("ArrayList: "+arraylist);
        System.out.println("First: "+arraylist.get(0));

        List<String> linkedlist=new LinkedList<>();
        linkedlist.add("Java");
        linkedlist.add("Python");
        linkedlist.add("React");

        linkedlist.add(0,"Spring Boot");

        System.out.println("LinkedList "+linkedlist);
        System.out.println("First: "+linkedlist.get(0));


    }
}