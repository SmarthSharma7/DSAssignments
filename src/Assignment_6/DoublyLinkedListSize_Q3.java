package Assignment_6;

public class DoublyLinkedListSize_Q3 {

    static class Node {
        int data;
        Node next, prev;
        Node(int d) { data = d; }
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        a.next = b; b.prev = a;
        b.next = c; c.prev = b;

        int count = 0;
        Node temp = a;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }
}

