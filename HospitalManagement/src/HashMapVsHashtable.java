import java.util.*;

public class HashMapVsHashtable{
    public static void main(String[] args){
        Map<Integer,String> hashmap=new HashMap<>();
        hashmap.put(101,"Jaya");
        hashmap.put(102,"Raju");
        hashmap.put(103,"Raj");

        hashmap.put(null,"Unkown");

        System.out.println("HashMap: " + hashmap);

         Map<Integer,String> hashtable=new Hashtable<>();
        hashtable.put(101,"Jaya");
        hashtable.put(102,"Raju");
        hashtable.put(103,"Raj");

        hashtable.put(null,"Unkown");

        System.out.println("HashTable: " + hashtable);


    }
}