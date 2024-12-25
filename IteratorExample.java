import java.util.*;


public class IteratorExample {

    public static void main(String[] args){ 

        List al = new ArrayList<>();

        al.add("Raghu Bhai");
        al.add("Jindal Bhai");
        al.add("Prince Bhai");

        ListIterator itr = al.listIterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        itr.previous();

        itr.set("Bichu Bhai");

        itr.next();

        System.out.println("-------------------------------");

        while(itr.hasPrevious()){
            System.out.println(itr.previous());
        }

    }
}
