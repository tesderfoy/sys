import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("один");
        list.add("два");
        list.add("три");
        list.add("два");
        list.add("один");
        list.add("сто");
        System.out.println(list);

       Set<String> set = new  LinkedHashSet<>(list);
       System.out.println(set);







    }
}