import java.util.*;

public class CollectionsDeepDive{
    public static void main(String[] args){
        List<String>name=new ArrayList<>();
        name.add("Abhi");
        name.add("Kuldeep");
        name.add("Rahul");
        name.add("Abhi");

        System.out.println("List: "+name);

        Set<String> uniqueNames=new HashSet<>();
        uniqueNames.add("Abhi");
        uniqueNames.add("Rahul");
        uniqueNames.add("Abhi");

        System.out.println("Set: "+uniqueNames);
        Map<Integer,String> student=new HashMap<>();

        student.put(101,"Abhi");
        student.put(102,"Raj");
        student.put(103,"Sarbjeet");

        System.out.println("Map: "+student);
    }
}