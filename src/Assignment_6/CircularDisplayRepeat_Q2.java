package Assignment_6;

public class CircularDisplayRepeat_Q2 {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        Node temp = node1;
        boolean first = true;
        while (temp != node1 || first) {
            if (first) first = false;
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}

