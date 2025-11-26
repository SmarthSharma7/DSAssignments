package Assignment_6;

public class CircularLinkedListSize_Q3 {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        a.next = b; b.next = c; c.next = a;

        int count = 0;
        Node temp = a;
        boolean first = true;
        while (temp != a || first) {
            first = false;
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }
}

