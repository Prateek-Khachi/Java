import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static class Node{
        public int data;
        Node left;
        Node right;
        public Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static Node create(ArrayList<Integer> v,int i){
        if(i<v.size()){
            if(v.get(i)==-1){
                return null;
            }
            Node root = new Node(v.get(i));
            root.left = create(v,2*i+1);
            root.right = create(v,2*i+2);
            return root;
        }
        return null;
    }

    public static void lv(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            while(n>0 && !q.isEmpty()){
                Node front = q.poll();
                System.out.print(front.data+" ");
                if(front.left!=null){
                    q.offer(front.left);
                }
                if (front.right!=null){
                    q.offer(front.right);
                }

                n--;
            }
            System.out.println();

        }
    }




    public static void in(Node root){
        if(root==null) return;

        in(root.left);
        System.out.print(root.data+" ");
        in(root.right);
    }
//iterative
    public static void main(String[] args){
        Node root = null;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        root = create(al,0);
        lv(root);
        System.out.println();
        in(root);

        String s = "@";
        char ch = s.charAt(0);


    }
}