import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String s = "anagram";

        String t = "naagram";

        char a[] = s.toCharArray();
        Arrays.sort(a);
        char b[] = t.toCharArray();
        Arrays.sort(b);
        System.out.println(a);
        System.out.println(b);

        if (Arrays.equals(a,b)) {
            System.out.println("true");

        }else{
            System.out.println("false");
        }
    }
}