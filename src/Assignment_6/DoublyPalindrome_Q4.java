package Assignment_6;

public class DoublyPalindrome_Q4 {

    static class Node {
        char data;
        Node next, prev;
        Node(char d) { data = d; }
    }

    public static void main(String[] args) {
        Node a = new Node('R');
        Node b = new Node('A');
        Node c = new Node('D');
        Node d = new Node('A');
        Node e = new Node('R');
        a.next = b; b.prev = a;
        b.next = c; c.prev = b;
        c.next = d; d.prev = c;
        d.next = e; e.prev = d;

        Node left = a;
        Node right = a;
        while (right.next != null) right = right.next;

        boolean palindrome = true;
        while (left != right && right.next != left) {
            if (left.data != right.data) {
                palindrome = false;
                break;
            }
            left = left.next;
            right = right.prev;
        }

        System.out.println(palindrome ? "Palindrome" : "Not Palindrome");
    }
}

