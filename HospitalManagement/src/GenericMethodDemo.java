public class GenericMethodDemo{
    public static <T> void printData(T data){
                System.out.println(data);

    }
    public static void main(String[]args){
        printData("Java Programming");
        printData(100);
        printData(99.99);
        printData(true);
    }
}