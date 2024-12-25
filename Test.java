import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static class Node{
        public int data;
        public Node next;
        public Node prev;
        Node(int d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node insert(int position,int val,Node head){

        if(position==0){
            return insertAtHead(val,head);
        }

        Node current = head;
        Node prev = head;
        Node newNode = new Node(val);
        for(int i=0;i<position;i++){
            prev = current;
            current = current.next;
        }
        if(current==null){
            newNode.prev = prev;
            prev.next = newNode;
            return head;
        }

        newNode.prev = prev;
        newNode.next = current;
        prev.next = newNode;
        current.prev = newNode;

        return head;

    }

    public static Node insertAtHead(int val,Node head) {
        if(head==null){
            head = new Node(val);
            return head;
        }

        Node newHead = new Node(val);
        newHead.next = head;
        head.prev = newHead;
        head = newHead;

        return head;

    }


    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }

    }


    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);

        Node head = null;
        head = insert(0,1,head);
        head = insert(0,-1,head);
        head = insert(0,3,head);
        head = insert(0,5,head);
        head = insert(2,2,head);
        head = insert(5,100,head);
        head = insert(5,99,head);

        print(head);




    }
}