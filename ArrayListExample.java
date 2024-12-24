import java.util.*;

public class ArrayListExample {

    public static void main(String[] args){

        ArrayList al = new ArrayList();

        al.add(10);
        al.add("oioaugyfscgckl");
        al.add('d');

        System.out.println(al);

        System.out.println(al.get(2));
        al.set(2,600);
        System.out.println(al.get(2));

        System.out.println(al.indexOf(600));
        System.out.println(al.contains(600));

        ArrayList al2 = new ArrayList();
        al2.addAll(al);

        System.out.println(al2);


        al2.removeAll(al2);
//        al2.add(1234567);
        System.out.println(al2);



    }
}
