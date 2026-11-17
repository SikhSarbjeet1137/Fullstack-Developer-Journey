import java.util.*;

public class HashSetVsTreeSet{
    public static void main(String[] args){
        Set<String> hashset=new HashSet<>();
        hashset.add("Java");
        hashset.add("Python");
        hashset.add("Java");
        hashset.add("Angular");

        System.out.println("HashSet: "+hashset);

        Set<String> treeset=new TreeSet<>();
        treeset.add("Java");
        treeset.add("Python");
        treeset.add("Java");
        treeset.add("Angular");

        System.out.println("TreeSet: "+treeset);
    }
}